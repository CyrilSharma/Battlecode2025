mask = """
    000000000
    000000000
    000000000
    000000000
    111000000
    111000000
    000000000
"""
rows = 7
cols = 9
for i in range(rows - 1, -1, -1):
    print(" ".join(mask[i * cols:(i + 1) * cols]))