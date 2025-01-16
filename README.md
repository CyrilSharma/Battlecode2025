# Repository for Team Om Nom

All the real code lives in the templates subdirectory of current.
You should install the vscode extention Better Jinja which will allow syntax highlighting.


# Modal Tester
Example:
```modal run modal_tester.py --team1=initialBot --team2=initialBot```

The tester will display each match result as it is determined as well as final statistics. It should take <5 minutes to run (the first time might take longer dur to container setup). 
Afterwards, you may want to inspect the replay files. You can get replays from a persistent network file system on Modal called "battlecode-vol". You can see the commands (view files with `modal nfs ls`, download files with `modal nfs get`, etc.) in https://modal.com/docs/reference/cli/nfs.