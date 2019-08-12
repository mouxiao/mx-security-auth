**Git Commit Msg**
>The reasons for these conventions:
- automatic generating of the changelog
- simple navigation through git history (eg. ignoring style changes)

**Format of the commit message:**
```html

<type>(<scope>): <subject>

<body>

<footer>
```
**Message subject (first line)**

> First line cannot be longer than 70 characters, second line is always blank and other lines should be wrapped at 80 characters.

_Allowed <type> values:_
- **_feat_** (new feature)
- _**fix**_ (bug fix)
- _**docs**_ (changes to documentation)
- _**style**_ (formatting, missing semi colons, etc; no code change)
- _**refactor**_ (refactoring production code)
- _**test**_ (adding missing tests, refactoring tests; no production code change)
- _**chore**_ (updating grunt tasks etc; no production code change)
> Example <scope> values:

- init
- runner
- watcher
- config
- web-server
- proxy
- etc.

The <scope> can be empty (eg. if the change is a global or difficult to assign to a single component), in which case the parentheses are omitted.

**Message body**

- uses the imperative, present tense: “change” not “changed” nor “changes”
- includes motivation for the change and contrasts with previous behavior
>For more info about message body, see:

- http://365git.tumblr.com/post/3308646748/writing-git-commit-messages
- http://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html

