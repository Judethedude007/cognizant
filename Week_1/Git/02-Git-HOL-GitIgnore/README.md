# Git HOL 2 - Git Ignore

## Objective
This hands-on exercise demonstrates how to use .gitignore to ignore unwanted files and folders.

## Files/Folders Created for Testing
- application.log
- log/system.txt

## Git Ignore Rules Added
- *.log
- log/
- **/log/

## What I Understood
The .gitignore file tells Git which files or folders should not be tracked. Log files are usually generated automatically by applications, so they should not be committed to the repository. After adding ignore rules, git status no longer shows the ignored log files.
