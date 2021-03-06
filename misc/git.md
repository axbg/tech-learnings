# Git Basics

## Local Repository

- `git help` 
	- displays all the available commands

- `git help *command*` 
	- displays informations about the specified command

- `git status` 
	- displays what has changed since the last commit

- `git init` 
	- initializes a new git repository

- `git add file`
	 - appends the current file to be added in the next commit
	- it's added to the "staged" area

- `git add --all` 
	- appends all modified files to the next commit
	- `git add *`

- `git commit` 
	- creates a new commit, including the staged files

- `git commit -m "comment"` 
	- creates a new commit and a message to describe it

- `git log` 
	- displays the history of commits and informations about them

- `git log --oneline` 
	- does the same thing, but only with essential data

- `git checkout branch_name` 
	- switches to the specified branch

- `git checkout -b new_branch_name` 
	- creates a new branch and switches to it

- `git merge branch_to_be_merged` 
	- merges the current branch to the specified one

- `git merge branch1 branch2` 
	- merges the second branch into the first one

- `git reset HEAD~n` 
	- resets the last n commits without removing the local files from hard disk

- `git reset --hard HEAD~n` 
	- resets the last n commits and deletes the local files from hard disk

- `git revert HEAD` 
	- reverts the last commit by creating a new commit that undoes everything that was done in the reverted commit 

- `git rebase branch` 
	- rebases the specified branch to the current one
	- more info about rebase - https://www.atlassian.com/git/tutorials/rewriting-history/git-rebase

- `git cherry-pick commit_hash` 
	- creates a copy of the specified commit under the local position
	- it's a safer alternative to rebase
	- commits are reffered by their hashes (ex: d467740)

- `git commit --amend` 
	- appends the staged files to the last commit without creating a new one

- `git tag tag_name commit_name` 
	- creates a new tag under the specified position
	- tags are used as references

- `git describe branch` 
	- displays the distance of the current branch from its last tag
		
- `git checkout .` 
	- removes the modifications from the unstaged files

- `git clean -f` 
	- removes the untracked files from the current location

#
## Remote Repository

- `git clone` 
	- clones a remote repository

- `git fetch` 
	- syncs the local and the remote repositories without altering the local one

- `git pull` 
	- syncs the local and the remote repositories and merges the remote repository into the local one

- `git pull --rebase` 
	- uses rebase instead of merge

- `git fakeTeamwork` 
	- simulates the creation of a new commit in the remote branch

- `git fakeTeamwork branch_name n` 
	- simulates the creation of n commits in the remote branch

- `git push` 
	- updates the remote repository, aplying the local commits that were newly created

- `git push repository_name branch_name` 
	- updates only a specific branch from a specific remote repository

- `git push origin branch1:branch2`
	 - updates a remote branch using a local branch as reference

- `git push origin :branch` 
	- deletes the specified branch from the remote repository

- `git checkout -b local_branch upstream_branch` 
	- creates a new local branch and set its track to an upstream one

- `git branch -u remote_branch local_branch local`
	 - sets the track between an upstream branch and a local one
