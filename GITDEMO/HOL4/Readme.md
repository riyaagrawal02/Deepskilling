# Git HOL 4 – Merge Conflict Resolution

## Objective

Learn how to resolve merge conflicts in Git.

---

## Files

```
HOL4/
├── README.md
├── hello.xml
└── .gitignore
```

---

## Commands Used

### Create Branch

```bash
git checkout -b GitWork
```

### Switch Branch

```bash
git checkout week6
```

### Merge Branch

```bash
git merge GitWork
```

### Resolve Conflict

Edit `hello.xml`, remove conflict markers, then:

```bash
git add Git/HOL4/hello.xml
git commit -m "Resolve merge conflict in HOL4"
```

### Ignore Backup Files

Create `.gitignore`

```gitignore
*.orig
```

Commit:

```bash
git add .gitignore
git commit -m "Ignore merge backup files"
```

### Delete Branch

```bash
git branch -d GitWork
```

### Push

```bash
git push
```

---

## Outcome

- Created a feature branch
- Generated a merge conflict
- Resolved the conflict manually
- Committed the resolved changes
- Ignored backup files
- Deleted the merged branch