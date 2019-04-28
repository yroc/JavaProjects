# Concepts Summary
## Programming, general
### Categorizing the input
When creating a program, a useful tip is to categorize the input into a finite number cases. Think about the input systematically (i.e., in order). For example, if the input is of type String, are strings of any length allowed? If so, start with the simplest case (i.e., the empty string), and work your way up. Maybe the empty string needs to be handled one way, and strings of length 1 or 2 must be handled a different way (but the same way as each other), and strings of length greater than 2 must be handled in yet a different way (but the same as each other).
### Using `if`, `if`, `if`, … vs `if`, `else-if`, `else-if`, …
The basic difference is that with separate `if` blocks, there is the possibility that each block may run (in case each condition is true). Whereas with an `if-else` block, only one subblock can run (regardless of whether or not more than one condition is true). For an example, try writing the `fizzBuzz()` method.

## Object orientation
### App design
From a *requirements document* (specifies what the app is required to do), it's up to you the programmer to determine what class(es) are needed to make the app—no one's going to tell you how to organize the code, certainly not your customer (who knows nothing about programming)!

There are many ways to organize an app into classes. For example, does it make sense that a BankAccount class encapsulates the mechanism to deposit and withdraw? If we're trying to mirror the app to real life, isn't a bank account merely a *container* of money? But if not the BankAccount class, which entity actually performs the depositing and withdrawing? Perhaps a “Teller” class? But then again, everything is so mechanized these days—there's not much paper money, and tellers don't really do the *actual* depositing, do they? Isn't it all done by computers? So maybe some kind of Computer class? Well, not really specific enough. Hmm…

Here are some general points to keep in mind when designing an app:
* Don't get into the habit of thinking that the way a textbook presents a solution is the only solution (or necessarily the best solution).
* There's no rule that apps must mirror real life; if it's convenient and logical to encapsulate the deposit and withdraw mechanisms (methods) as part of the ”bank account”, then do it. If you can think of something better, then do that.

## Java
### Where to save source code?
*Not* directly in the project folder! Example where to place the MathGames.java file:

`~/JavaProjects/src/main/java/com/example/math/`

* `src/main/java/` follows the *Gradle* standard.
* `com/example` is the reverse domain portion of the directory—its purpose is to provide a namespace for the package name.
* `math/` is the actual package directory.
* Make nested directories in *Emacs* with `M-x make-directory`
* Or, from the shell, using `mkdir --parents`
* Check that the directory hierarchy was successfully created with `ls -R`

### What are packages?
A grouping of related classes and/or interfaces
#### Grouping mechanism
* All classes and interfaces belonging to the same packages are placed in the same directory
* Each source file contains a *package declaration*, which declares the name of the package the type belongs to
* Package name mirrors the directory hierarchy that the source files are placed in
#### Why packages?
* Organizing types into logical categories makes it easier for the programmer and client to find them
* Provies a namespace to prevent class naming conflicts
* A means of access control (e.g., if a member of a class is `protected`, then it can be invoked/accessed within the package but not outside the package)

### When `import` statements are needed
* Types located outside the current class's package (exception: `java.lang` package).
* You can always write out a type's fully qualified name in lieu of an import statement.

### Compiling
Compiling is done by the JDK tool `javac`:

> The `javac` tool reads class and interface definitions, written in the Java programming language, and compiles them into bytecode class files.

Taking the example of the `MathGames.java` source file in the `com.example.math` package, and assuming the working directory is the project directory `~/JavaProjects/`, the compile command would be:

`javac -d bin/main/java/ -verbose -Xlint src/main/java/com/example/math/MathGames.java`

* `-d` option: specifies the directory to put the compiled (`.class`) file. Note that source (`.java`) files should be located in `src/main/java/`, and compiled files in `bin/main/java/` as per the *Gradle* standard. If `bin/main/java` doesn't exist, it must be created first:

 `mkdir --parents bin/main/java/`

 or, from *Emacs*,

 `M-x make-directory RET bin/main/java/`

 Also note that the compiled file will be placed at location

 `bin/main/java/com/example/math/`

 not

 `bin/main/java/`

 even though the package directory hierarchy is not specified after the `-d` option. This is because `javac` is programmed to do this (it knows the package hierarchy from the *package declaration* in the source file).

* `-verbose` option: tells `javac` to print out what it's doing (could be good for diagnosing errors)
* `-Xlint` option: Enable all warnings

### Running an app
JDK tool `java` (*Java launcher*):

> The `java` tool launches a Java application. It does this by starting a Java runtime environment, loading a specified class, and invoking that class's `main` method.

You can run the `MathGames` class from *any* directory by specifying `MathGames`'s location with the (*classpath*) option `-cp`:

`java -cp ~/JavaProjects/bin/main/java/ com.example.math.MathGames`

Or else you must `cd` to `MathGames`'s location and run it from there:

```shell
$ cd ~/JavaProjects/bin/main/java/
$ java com.example.math.MathGames
```
#### Some explanatory notes
* `java` is programmed to expect a class's proper name as its argument, not its pathname (location). That's why you need the `-cp` option to specify the class's location and can't just run a class like this:

  `java ~/JavaProjects/bin/main/java/com/example/math/MathGames.class`

  Furthermore, `java` is programmed to expect the *fully qualified* class name (e.g., `com.example.math.MathGames`), not just the class's root name (e.g., `MathGames`).
* When specifying the class's location with `-cp`, `java` is programmed to expect its location within the project *excluding* the “package” part of its location. That is, `java` expects:

  `-cp ~/JavaProjects/bin/main/java/`

  not:

  `-cp ~/JavaProjects/bin/main/java/com/example/math/`
* It's not enough to tell `java` which class to run; it must also be told *where* to look for it. One way to do this is with the `-cp` option explained above. Another way is via the environmental variable `CLASSPATH`, which represents a list of pathnames (locations) for `java` to search. `java` will search—and only search—the locations specified by `CLASSPATH`; if the given class is not located in one of the directories specified in `CLASSPATH`, then `java` will complain that it couldn't find the class and won't run it.

  By default, `CLASSPATH` is set to the working directory only. This is why `cd`ing directly to a class's location (e.g., `~/JavaProjects/bin/main/java/`) allows `java` to find the class even if the `-cp` option isn't used.

  **Note**: It is considered bad practice to set `CLASSPATH` and rely on it. It is recommended to leave `CLASSPATH` alone and to always use `-cp`.

### Java check version
`java --version`

## Git
### Check Git installation
`git --version`
### Placing an app under Git verison control
#### Configure Git
```shell
$ git config --global user.name John Doe
$ git config --global user.email johndoe@gmail.com
$ git config --global core.editor "emacs -nw"
```

* These commands edit the *global* config file (located at `~/.gitconfig`).
* There are also a *local* (viz., project specific) config files, called `config`, located in each project's `.git/` directory.

#### Creating a Git repository for a project
Directly within the project directory, enter the command `git init` (this creates the `.git/` directory—the repository).

#### View the current status
`git status`

#### Ignoring files
You want to ignore all compiled files (`.class` files in the case of Java). Git will ignore (not track) all files identified in a file called `.gitignore` (you create this file yourself just inside the project directory):

`emacs -nw .gitignore`

To ignore `.class` files, you can do either:

```
# Compiled class files
*.class
```

or

```
# bin/ directory
bin/
```

#### Staging untracked files
Examples:

```
git add .
git add *.java
git add README.md
```

#### Committing files to the repository
##### Commit with a one-line commit message
For example, committing a new file:

`git commit -m "Initialize"`

##### Commit with a subject and body commit message
When you need to explain the change in more detail. The format is like an email; the subject *summarizes*  what you've done, while the body describes in more detail what you've done *and* explains *why* you've done it (but not how you've done it—leave the “how” out of it).

Summary of Chris Beams' Git commit message rules:
Subject line: Separate subject from body with a blank line, limit to 50 chars, sentence case, don't  end with a period, imperative mood.
Body: Wrap at 72 characters, as many paragraphs as you need, bullet points are OK (use dash or asterisk as bullet).

* To wrap at 72 characters, use `C-x f` to set fill-column width, and `M-q` to fill a paragraph.

### Transfering project to Github (remote repository)
#### Create a new remote repository
1. Sign into github.com
2. Look for a “New” button (as in, create a new repository)
3. Pick a repository name (e.g., `JavaProjects`) and a description (e.g., `A collection of Java projects for practice.`

#### Establish a connection between the local and remote repository
`git remote add origin https://github.com/yroc/JavaProjects.git`

#### Upload local repository
`git push -u origin master`

For subsequent pushes (uploads), you only need `git push`

### Add a README.md
Each Git repository has at least one `README.md` file. Each subdirectory in the project hierarchy can have its own `README.md`.

### Renaming a file in Git
`git mv Sequences.java MathSequenceGenerator.java`

### Download and integrate remote changes (e.g., from Github.com)
`git pull`

## Linux
### Create a new (empty) file
<code>touch <var>filename</var></code>

### Extracting and decompressing a `tar.gz` file
A `.tar` file is a "container" file that groups two or more separate files into a single unified file (called an *archive* file, with extension `.tar`). The Linux program that does this is called `tar`. But as a user, you're more likely to be *extracting* members of an archive file than creating archive files.

In addition to archiving files, it is common to *compress* the newly-created archive to save space (especially important when sending files over a network). The most common Linux program for doing this is `gzip`. You can easily tell that an archived file has been compressed with `gzip` because it has the extension `.gz` (e.g., `example.tar.gz`).
#### Extract and decompress a `tar.gz` file

`tar -xvf example.tar.gz`

* `x` (required), means extract. This option is required because `tar` also archives files, and you need to tell it which of the two operations you want it to do.
* `v` (optional), means "be verbose". `tar` prints to the console what it's doing while it's doing it. Useful to ensure especially when extracting large archives so you know that `tar` didn't freeze or something.
* `f` (required, must be last), means, "Operate on the given file". This option is required because `tar` is programmed to operate on a "default" file if a file is not specified (see https://www.gnu.org/software/tar/manual/tar.html#SEC14 for more detail)

Note that you can also include the command option `z`, which tells `tar` to decompress the file using `gzip`, but `tar` is programmed to automatically decompress the given file using `gzip` when the given file extension is `.gz`.

## Emacs
### Scroll other window
`C-M-v` (scroll up)\
`C-M-S-v` (scroll down)

### Packages
Since version 24.1, *Emacs* includes the *built-in* ability to manage *packages*—Emacs Lisp programs that implement additional features (§48). This built-in package manager is an Emacs Lisp program called `package.el`.

Packages themselves are stored in *package archives*, aka *repositories*. Although there are several Emacs package archives, there is only one *official* archive, called *ELPA* (Emacs Lisp Package Archive). “Official” means that this is the repository pre-packed with Emacs and is copyrighted by the *Free Software Foundation* (and it is perhaps the case that its packages are more strictly controlled in terms of quality assurance). It's also generally recognized that *ELPA* contains are relatively small number of packages. Thus the interest in third-party package archives…

If you want the package manager to search third-party repositories (e.g., *MELPA*), you have to tell it to do so. MELPA, as well as *MarmaladeRepo*, are the most popular third-party Emacs package repos.

#### Adding the MELPA repository
This is done with eLisp code in your init file (see init file).

#### Installing (and deleting) packages
1) `M-x list-packages` to open a buffer listing all packages from all installed repos.
2) `ENT` to describe the package under cursor (optional)
3) `i` to mark the package on the current line for installation (or `d` to mark for uninstallation). Also useful is `u` to remove an install or delete  mark if you make a mistake.
4) `x` to execute all marked installations and deletions

#### Installed package location
`~/.emacs.d/elpa`
