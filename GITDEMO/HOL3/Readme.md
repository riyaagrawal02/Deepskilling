# Git HOL 3 – Branching & Merging

## Objective

Learn how to create, switch, merge, and delete Git branches.

---

## Files

```
HOL3/
├── README.md
└── notes.txt
```

---

## Commands Used

### Create Branch

```bash
git branch GitNewBranch
```

### List Branches

```bash
git branch
```

### Switch Branch

```bash
git checkout GitNewBranch
```

or

```bash
git switch GitNewBranch
```

### Modify File

```bash
echo "This line was added in GitNewBranch." >> notes.txt
```

### Stage Changes

```bash
git add .
```

### Commit

```bash
git commit -m "Update notes in GitNewBranch"
```

### Return to Main Branch

```bash
git checkout week6
```

### Merge

```bash
git merge GitNewBranch
```

### View History

```bash
git log --oneline --graph --all
```

### Delete Branch

```bash
git branch -d GitNewBranch
```

### Push

```bash
git push
```
---

## Outcome

- Created a new branch
- Switched between branches
- Committed changes
- Merged the branch into `week6`
- Viewed commit history
- Deleted the merged branch