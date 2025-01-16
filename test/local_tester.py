import asyncio
import os
import random
import sys
from asyncio import Semaphore

from test.common import read_maps, parse_results_text

a_wins, b_wins = 0, 0

def parse_results(path: str):
    a_won, b_won = 0, 0
    with open(path, "r") as f:
        i = iter(f)
        a_won, b_won = parse_results_text(i)
    return (a_won, b_won)


async def run_game(a: str, b: str, map: str, ooo: int, sem: Semaphore):
    path = f"test/{map}{ooo}.txt"
    async with sem:
        command = (
            "./gradlew run"
            + f" -PteamA={a}"
            + f" -PteamB={b}"
            + f" -Pmaps=\"{map}\""
            + f" -Psource=src"
            + f" -PprofilerEnabled=false"
            + f" -PoutputVerbose=false"
        )
        with open(path, "w") as f:
            process = await asyncio.create_subprocess_shell(
                command, shell=True, stdout=f, stderr=asyncio.subprocess.PIPE
            )
            await process.wait()
            f.flush()

    global history, a_wins, b_wins
    p1_won, p2_won = parse_results(path)
    a_wins += p2_won if (ooo) else p1_won
    b_wins += p1_won if (ooo) else p2_won
    print(f"{map:<15} -> {a if p1_won else b} wins!{' ' * 20}")
    print(
        f"{b if ooo else a} wins: {a_wins} | {a if ooo else b} wins: {b_wins}",
        end="\r",
        flush=True,
    )


async def play(a: str, b: str, maps: [str]):
    print(f"{a} wins: 0 | {b} wins: 0", end="\r", flush=True)

    random.shuffle(maps)
    sem = asyncio.Semaphore(8)

    tasks = []
    for i in range(len(maps)):
        tasks.append(run_game(a, b, maps[i], 0, sem))
        tasks.append(run_game(b, a, maps[i], 1, sem))
    await asyncio.gather(*tasks)


async def main():
    print("Starting Tests!")
    random.seed(42)
    if len(sys.argv) < 3:
        print("Usage: python3 tester.py [Player1] [Player2] [Maps]?")
        exit(1)
    a, b = sys.argv[1:3]
    maps = sys.argv[3:] if len(sys.argv) >= 4 else read_maps()
    await play(a, b, maps)


if __name__ == "__main__":
    asyncio.run(main())