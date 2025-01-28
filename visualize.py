rows = 7
cols = 9
mask = 0x1F02000000000000    # Your hex value
str = format(mask, '064b')[::-1]
# As we go through the bits, we first go right and then up.
for i in range(rows - 1, -1, -1):
    print(" ".join(str[i * cols:(i + 1) * cols]))