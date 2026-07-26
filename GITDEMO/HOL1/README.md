# Git HOL 1 – Git Configuration & Basic Commands

This hands-on demonstrates the basic Git workflow including configuration, repository initialization, staging, committing, and pushing changes.

---

## Objectives

- Verify Git installation
- Configure Git username and email
- Configure the default editor (optional)
- Create and initialize a Git repository
- Create and track files
- Commit changes
- Connect to a remote repository
- Push and pull changes

---

## Commands Used

### 1. Check Git Installation

```bash
git --version
```

Displays the installed Git version.

Example:

```
git version 2.50.1.windows.1
```

---

### 2. Configure Git Username

```bash
git config --global user.name "Your Name"
```

Sets the global username for all Git repositories.

---

### 3. Configure Git Email

```bash
git config --global user.email "your-email@example.com"
```

Sets the global email address.

---

### 4. Verify Git Configuration

```bash
git config --global --list
```

Displays all configured Git settings.

---

### 5. Configure Default Editor (Optional)

For Notepad++:

```bash
git config --global core.editor "notepad++.exe -multiInst -nosession"
```

For Visual Studio Code:

```bash
git config --global core.editor "code --wait"
```

---

### 6. Create Project Folder

```bash
mkdir GitDEMO
cd GitDEMO

mkdir HOL1
cd HOL1
```

Creates the directory for Git HOL 1.

---

### 7. Create a File

```bash
echo "Welcome to the version control" > welcome.txt
```

Creates `welcome.txt` with sample content.

---

### 8. View File Contents

```bash
cat welcome.txt
```

Displays the contents of the file.

---

### 9. Check Repository Status

```bash
git status
```

Shows tracked, untracked, modified, and staged files.

---

### 10. Stage Files

Stage a single file:

```bash
git add welcome.txt
```

Stage all files:

```bash
git add .
```

Moves files from the Working Directory to the Staging Area.

---

### 11. Commit Changes

```bash
git commit -m "Complete Git HOL 1"
```

Creates a snapshot of staged changes.

---

### 12. View Commit History

```bash
git log
```

Displays detailed commit history.

Short version:

```bash
git log --oneline
```

---

### 13. Create a Remote Repository

Add GitHub as the remote repository.

```bash
git remote add origin <repository-url>
```

Example:

```bash
git remote add origin https://github.com/username/Deepskilling.git
```

---

### 14. Verify Remote

```bash
git remote -v
```

Lists configured remote repositories.

---

### 15. Pull Latest Changes

Main branch:

```bash
git pull origin main
```

Master branch:

```bash
git pull origin master
```

Downloads and merges remote changes.

---

### 16. Push Changes

First push:

```bash
git push -u origin week6
```

Subsequent pushes:

```bash
git push
```

Uploads local commits to GitHub.

---

## Git Workflow

```
Working Directory
        │
        ▼
git add
        │
        ▼
Staging Area
        │
        ▼
git commit
        │
        ▼
Local Repository
        │
        ▼
git push
        │
        ▼
Remote Repository (GitHub)
```

---

## Quick Reference

| Command | Purpose |
|---------|---------|
| `git --version` | Check Git installation |
| `git config --global user.name` | Set username |
| `git config --global user.email` | Set email |
| `git config --global --list` | View configuration |
| `git init` | Initialize repository |
| `git status` | Check repository status |
| `git add .` | Stage all files |
| `git commit -m` | Commit staged files |
| `git log --oneline` | View commit history |
| `git remote add origin` | Add remote repository |
| `git remote -v` | View remote repository |
| `git pull` | Download latest changes |
| `git push` | Upload commits to GitHub |

---

## Outcome

After completing this hands-on, you will be able to:

- Configure Git
- Create a Git repository
- Track files
- Commit changes
- View commit history
- Connect to GitHub
- Push and pull code using Git