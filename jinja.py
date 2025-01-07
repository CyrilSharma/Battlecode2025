import argparse
from jinja2 import Environment, FileSystemLoader, nodes
from jinja2.ext import Extension

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


# Set up the Jinja2 environment
env = Environment(loader=FileSystemLoader("templates"))
env.add_extension(DebugExtension)

# Load and render the template
template = env.get_template("example.jinja")
rendered_output = template.render()

print("Rendered Output:")
print(rendered_output)