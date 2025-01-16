# Repository for Team Om Nom

# Build System
All the real code lives in the templates subdirectory of current.
We use jinja to make unrolling java easy. You should install the vscode extention Better Jinja which will allow syntax highlighting.

Our build system uses make to invoke a script (jinja.py) which compiles the templates directory.
To make python versioning easy, we use https://github.com/astral-sh/uv. 

Commands
```make```
The most common command you will run, it instatiates all template code.
All make commands below will also do this.
The code is dumped in src/current.

```make clean```
Purges the src/current directory.

```make test```
Runs the modal tester.

```make clone```
Creates a new baseline.

```make zip```
Generates a submission file.

# Modal Tester
Make invocation
```make test BASELINE=sprint1Bot```

Direct invocation:
```modal run modal_tester.py --team1=initialBot --team2=initialBot```

The tester will display each match result as it is determined as well as final statistics. It should take <5 minutes to run (the first time might take longer dur to container setup). 

Afterwards, you may want to inspect the replay files. You can get replays from a volume on Modal called "battlecode-vol". See the modal documentation for more information.

