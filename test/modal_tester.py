# Testing using Modal for access to massive amounts of compute
# The container's files sync with your local ones, so make sure
# that you have run ./gradlew update ./gradlew build locally first

import os
import modal
from modal import Image
from test.common import parse_results_text, read_maps


app = modal.App()
volume = modal.Volume.from_name("battlecode-vol", create_if_missing=True)
LOCAL_PROJECT_DIR = "./java"


def get_info():
    import subprocess
    output = subprocess.run(
        ["ls", "-l", "/usr/lib/jvm/"],
        capture_output=True,
        text=True,
        check=True
    ).stdout
    print("get info:")
    print(output)

def gradlew_setup():
    import subprocess
    # Converts linux format \n to DOS format, \r\n
    subprocess.run(
        ["dos2unix", "gradlew"],
        capture_output=True,
        check=True
    )
    try:
        output = subprocess.run(
            ["bash", "gradlew"],
            capture_output=True,
            check=True
        )
        print(output)
    except subprocess.CalledProcessError as e:
        print(e.returncode)
        print(e.output)
        print(e.stderr)
    


# https://askubuntu.com/questions/931610/how-to-install-jdk8-on-ubuntu-16
# https://askubuntu.com/questions/1139387/update-to-latest-version-of-java-after-ppa-is-discontinued
# http://www.webupd8.org/2014/03/how-to-install-oracle-java-8-in-debian.htmlsudo
# https://stackoverflow.com/questions/10268583/downloading-java-jdk-on-linux-via-wget-is-shown-license-page-instead
# https://docs.datastax.com/en/jdk-install/doc/jdk-install/installOracleJdkDeb.html
image = (
    Image.from_registry("ubuntu:22.04", add_python="3.11")
    .apt_install(["openjdk-21-jdk"])
    .run_function(get_info)
    .apt_install(["dos2unix"])
    
    .add_local_dir(os.path.join(LOCAL_PROJECT_DIR, "gradle"), remote_path="/root/gradle", copy=True)
    .add_local_file(os.path.join(LOCAL_PROJECT_DIR, "build.gradle"), remote_path="/root/build.gradle", copy=True)
    .add_local_file(os.path.join(LOCAL_PROJECT_DIR, "gradle.properties"), remote_path="/root/gradle.properties", copy=True)
    .add_local_file(os.path.join(LOCAL_PROJECT_DIR, "gradlew"), remote_path="/root/gradlew", copy=True)
    .add_local_dir(os.path.join(LOCAL_PROJECT_DIR, "build/libs"), remote_path="/root/build/libs", copy=True)
    .add_local_dir(os.path.join(LOCAL_PROJECT_DIR, "client"), remote_path="/root/client", copy=True)
    .add_local_dir(os.path.join(LOCAL_PROJECT_DIR, ".gradle"), remote_path="/root/.gradle", copy=True)
    .add_local_file(os.path.join(LOCAL_PROJECT_DIR, "client_version.txt"), remote_path="/root/client_version.txt", copy=True)
    .add_local_file(os.path.join(LOCAL_PROJECT_DIR, "engine_version.txt"), remote_path="/root/engine_version.txt", copy=True)
    .run_function(gradlew_setup)

    .add_local_dir(os.path.join(LOCAL_PROJECT_DIR, "maps"), remote_path="/root/maps")
    .add_local_dir(os.path.join(LOCAL_PROJECT_DIR, "src"), remote_path="/root/src")
)

@app.function(
    image=image,
    volumes={"/root/matches_final": volume}
)
def tester(team1: str, team2: str, map: str):
    import subprocess
    import os
    import shutil

    def get_reason(text):
        for line in text:
            if not line.startswith("[server]"):
                continue
            if "Reason: " in line:
                return line.split("Reason: ")[1]

    command = (
        "./gradlew run"
        + f" -PteamA={team1}"
        + f" -PteamB={team2}"
        + f" -Pmaps=\"{map}\""
        + f" -Psource=src"
        + f" -PprofilerEnabled=false"
        + f" -PoutputVerbose=false"
    )

    output = ''
    try:
        output = subprocess.run(
            command, capture_output=True, check=True, shell=True
        )
    except subprocess.CalledProcessError as e:
        print(e.returncode)
        print(e.output)
        print(e.stderr)
        return
    
    lines = output.stdout.decode().split("\n")
    team1_game1, team2_game1 = parse_results_text(lines)
    winner = team1 if team1_game1 else team2
    winningPlayer = 'PlayerA' if team1_game1 else 'PlayerB'

    result = f"{winner} wins on map {map} as {winningPlayer} for reason: {get_reason(lines)}"
    print(result)

    for file in os.listdir("/root/matches/"):
        shutil.copyfile("/root/matches/" + file, "/root/matches_final/" + file)
        
    return {
        team1: team1_game1,
        team2: team2_game1
    }, {
        map: result
    }


@app.local_entrypoint()
def main(team1: str, team2: str, mapfile: str):
    tot = {
        team1: 0,
        team2: 0
    }
    maps = read_maps(f"./test/{mapfile}")
    results = { map: [] for map in maps }
    num_games = len(maps)

    print("-------------LIVE------------")
    for result in tester.map(
        [team1] * (num_games) + [team2] * (num_games),
        [team2] * (num_games) + [team1] * (num_games),
        maps + maps,
        return_exceptions=True
    ):
        output, mapres = result 
        if isinstance(mapres, dict):
            for map, str in mapres.items():
                results[map].append(str)

        if isinstance(output, dict):
            for player, wins in output.items():
                tot[player] += wins
        else:
            print(output)

    print("-------------SUMMARY------------")
    for map, res in results.items():
        for item in res: print(item)
    print(f"{team1} wins: {tot[team1]}, {team2} wins: {tot[team2]}")