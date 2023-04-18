#!/bin/bash

# ******* MKdocs startup script ********

# ---------------------------------------------------------------------
# Description      : Bash script for mkdocs start
# ---------------------------------------------------------------------


# Starting MKdocs server
echo -e "\n######################  MKdocs Start  #####################\n"
gnome-terminal -- sh -c 'cd /home/nenad/Build/jenkins_sandbox/workshop_presentation && mkdocs serve -a 127.0.0.1:9005; bash'
