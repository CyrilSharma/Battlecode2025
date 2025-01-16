from typing import Iterable
def read_maps():
    maps = []
    with open("test/maps.txt", "r") as f:
        f_iter = iter(f)
        for line in f_iter:
            data = line.rstrip()
            maps.append(data)
    return maps

def parse_results_text(text: Iterable[str]):
    a_won, b_won = 0, 0
    match_started = False
    for line in text:
        if not line.startswith("[server]"):
            continue
        if "match starting" in line.lower():
            match_started = True
            continue
        if not match_started:
            continue
        if "wins" in line.lower():
            a_won = int("(A)" in line)
            b_won = int("(B)" in line)
            break
        elif "loses" in line.lower():
            a_won = 1 - int("(A)" in line)
            b_won = 1 - int("(B)" in line)
    return a_won, b_won