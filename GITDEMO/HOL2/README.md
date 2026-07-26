# Git HOL 2 – .gitignore

## Objective

Learn how to ignore unwanted files and folders using `.gitignore`.

---

## Files Created

```
HOL2/
├── .gitignore
├── README.md
├── app.log
├── error.log
└── log/
    └── debug.txt
```

---

## .gitignore

```gitignore
# Ignore log files
*.log

# Ignore log directory
log/
```

---

## Commands

### Create Files

```bash
touch app.log
touch error.log

mkdir log

touch log/debug.txt
```

### Check Status

```bash
git status
```

### Stage

```bash
git add .
```

### Commit

```bash
git commit -m "Complete Git HOL 2"
```

### Push

```bash
git push
```

---

## Expected Result

Ignored:

- `app.log`
- `error.log`
- `log/`

Tracked:

- `.gitignore`
- `README.md`

---

## Outcome

Successfully ignored unwanted log files and directories using `.gitignore`.