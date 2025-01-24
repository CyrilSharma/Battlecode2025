import argparse
from jinja2 import Environment, FileSystemLoader, nodes
from jinja2.ext import Extension
from collections import defaultdict


# Define the DebugExtension class
class DebugExtension(Extension):
    # Register the custom tag
    tags = {"debug"}

    def parse(self, parser):
        # Get the line number where the `debug` tag is used
        lineno = next(parser.stream).lineno

        # Parse the arguments (this will handle multiple expressions)
        args = [nodes.Const(lineno)]

        # Check if more expressions follow
        while parser.stream.current.type != 'block_end':
            args.append(parser.parse_expression())

        # Return a CallBlock node for the `debug` function
        return nodes.CallBlock(
            self.call_method("_debug", args), [], [], [], lineno=lineno
        )

    def _debug(self, lineno, *args, caller):
        flattened_args = []
        for arg in args:
            # Weird quirk, sometimes args is a tuple of tuples, sometimes it's a tuple.
            if isinstance(arg, tuple): flattened_args.extend(arg)
            else: flattened_args.append(arg)
        message = ' + ", " + '.join(f'"{str(arg)} = " + {str(arg)}' for arg in flattened_args)
        return f'System.out.println("[{lineno}] " + {message});'


# Define bitwise operations
def bitAnd(value1, value2):
    return value1 & value2

def bitOr(value1, value2):
    return value1 | value2

def bitLeftShift(value1, value2):
    return value1 << value2

def bitRightShift(value1, value2):
    return value1 >> value2

def intDiv(value1, value2):
    return value1 // value2

def capitalizeFirstLetter(s):
    if not s: return s
    return s[0].upper() + s[1:]

def computeIncomeMap(maxSrps, maxMoneyTowers):
    mp = defaultdict(list)
    for srps in range(0, maxSrps):
        for moneyTowers in range(0, maxMoneyTowers):
            supposedIncome = moneyTowers * (20 + (3 * srps))
            mp[supposedIncome].append((moneyTowers, srps))

            if moneyTowers > 0:
                # One of the money towers can be leveled...
                supposedIncome = (30 + (3 * srps)) + (moneyTowers - 1) * (20 + (3 * srps))
                mp[supposedIncome].append((moneyTowers, srps))
    return dict(mp)

def main():
    parser = argparse.ArgumentParser(description="Generate a .java file from a .java.jinja2 template.")
    parser.add_argument("--input", required=True, help="Path to the input .java.jinja2 template file.")
    parser.add_argument("--output", required=True, help="Path to the output .java file.")
    parser.add_argument("--prod", required=True, help="Mode of generation (e.g., 'true' for production, 'false' for debug).")
    args = parser.parse_args()

    print(args.input)
    print(args.output)
    env = Environment(loader=FileSystemLoader(searchpath='./'))
    env.add_extension(DebugExtension)

    # Add global utility functions.
    env.globals['bitAnd'] = bitAnd
    env.globals['bitOr'] = bitOr
    env.globals['bitLeftShift'] = bitLeftShift
    env.globals['bitRightShift'] = bitRightShift
    env.globals['intDiv'] = intDiv
    env.globals['capitalizeFirstLetter'] = capitalizeFirstLetter
    env.globals['computeIncomeMap'] = computeIncomeMap
    template = env.get_template(args.input)
    rendered_content = template.render(
        directions=[
            'Direction.NORTH',
            'Direction.NORTHEAST',
            'Direction.EAST',
            'Direction.SOUTHEAST',
            'Direction.SOUTH',
            'Direction.SOUTHWEST',
            'Direction.WEST',
            'Direction.NORTHWEST',
            'Direction.CENTER'
        ],
        shortDirections=[
            'N',
            'NE',
            'E',
            'SE',
            'S',
            'SW',
            'W',
            'NW',
            'C'
        ],
        prod=(args.prod == 'True')
    )
    with open(args.output, 'w') as output_file:
        output_file.write(rendered_content)

if __name__ == "__main__":
    main()
    