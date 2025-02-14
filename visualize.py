import argparse
from rich.console import Console
from rich.table import Table

def display_mask(mask: int, rows: int = 7, cols: int = 9):
    binary_str = format(mask, '064b')[::-1]
    console = Console()
    table = Table(title="Binary Mask", show_header=False, show_lines=True)
    
    for _ in range(cols):
        table.add_column()
    
    for i in range(rows - 1, -1, -1):
        row_data = [f"[green]█[/]" if bit == '1' else f"[red]█[/]" for bit in binary_str[i * cols:(i + 1) * cols]]
        table.add_row(*row_data)
    
    console.print(table)

def main():
    parser = argparse.ArgumentParser(description="Display a binary mask as a table using rich.")
    parser.add_argument("mask", type=lambda x: int(x, 16), help="Hexadecimal mask value (e.g., 0x1F02000000000000)")
    parser.add_argument("--rows", type=int, default=7, help="Number of rows in the mask display (default: 7)")
    parser.add_argument("--cols", type=int, default=9, help="Number of columns in the mask display (default: 9)")
    args = parser.parse_args()
    
    display_mask(args.mask, args.rows, args.cols)

if __name__ == "__main__":
    main()
