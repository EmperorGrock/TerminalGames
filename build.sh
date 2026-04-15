#!/bin/bash



echo "Creating .JAR..."
jar cfm TerminalGames.jar MANIFEST.MF -C bin . 

echo "Finished."