# App List
1. `BankAccount`
2. `FizzBuzz`
3. `FibonacciSequence`
4. `Addends`

# Concepts Summary
## App design
From a *requirements document* (specifies what the app is required to do), it's up to you the programmer to determine what class(es) are needed to make the app—no one's going to tell you how to organize the code, certainly not your customer (who knows nothing about programming)!

There are many ways to organize an app into classes. For example, does it make sense that a BankAccount class encapsulates the mechanism to deposit and withdraw? If we're trying to mirror the app to real life, isn't a bank account merely a *container* of money? But if not the BankAccount class, which entity actually performs the depositing and withdrawing? Perhaps a “Teller” class? But then again, everything is so mechanized these days—there's not much paper money, and tellers don't really do the *actual* depositing, do they? Isn't it all done by computers? So maybe some kind of Computer class? Well, not really specific enough.Hmm…

Here are some general points to keep in mind when designing an app:
* Don't get into the habit of thinking that the way a textbook presents a solution is the only solution (or necessarily the best solution).
* There's no rule that apps must mirror real life; if it's convenient and logical to encapsulate the deposit and withdraw mechanisms (methods) as part of the ”bank account”, then do it. If you can think of something better, then do that.

## Where to save source code?
*Not* directly in the project folder! Example where to place the BankAccount.java file:

`~/JavaProjects/src/main/java/com/mathcomputers/math/finance/`

* `src/main/java/` follows the *Gradle* standard.
* `com/mathcomputers` is the reverse domain portion of the directory—its purpose is to provide a namespace for the package name.
* `math/finance` is the actual package directory.
* Make nested directories in *Emacs* with `M-x make-directory`
* Or, from the shell, using `mkdir --parents`
* Check that the directory hierarchy was successfully created with `ls -R`

## What are packages?
A grouping of related classes and/or interfaces
### Grouping mechanism
* All classes and interfaces belonging to the same packages are placed in the same directory
* Each source file contains a *package declaration*, which declares the name of the package the type belongs to
* Package name mirrors the directory hierarchy that the source files are placed in
### Why packages?
* Organizing types into logical categories makes it easier for the programmer and client to find them
* Provies a namespace to prevent class naming conflicts
* A means of access control (e.g., if a member of a class is `protected`, then it can be invoked/accessed within the package but not outside the package)
##Source file structure
Every class has the general structure
1. Package declaration: tells the compiler which package this class belongs to
2. Import statement(s): tells the compiler where to find types that belong to other packages (i.e., packages outside this class's package)
3. Class header and body

## When import statements are needed
Types located outside the current class's package (exception: `java.lang` package).

## Compiling
Important points to keep in mind:
* `javac` is run from just outside the package directory. For example, from here:

  `JavaProjects/src/main/java/`

  Not from where the actual source file is located. For example, *not* from here:

  `JavaProjects/src/main/java/com/mathcomputers/math/finance/`

  Reason being, the package declaration (in the source file) tells the compiler to look for the source files in the directory hierarchy `com/mathcomputers/math/finance` *relative to the current directory*.
* Another consideration is separating source code from compiled code. Do this by creating a separate `bin` directory branch. For example:

  ~/JavaProjects/bin/main/java/

  Then, to tell `javac` to put its output in the “bin branch”, use the `-d` option (“directory”). For example:

  `javac -d ~/JavaProjects/bin/main/java/ com/mathcomputers/math/finance/BankAccount.java`

## Running an app
Again, navigate to just outside the package directory. For example, from here:

`bin/src/java/`

Use the package name, not the filename:

`java com.mathcomputers.math.finance.BankAccount`

## Placing an app under Git verison control
### Check Git installation
`git --version`

### Configure Git
```
git config --global user.name John Doe
git config --global user.email johndoe@gmail.com
git config --global core.editor "emacs -nw"
```

* These commands edit the config file.
  * The *global* config file is located at `~/.gitconfig`.
  * *Local* (i.e., project specific) config files are called `config` and located in the `.git/` directory inside each project directory.

### Creating a Git repository for a project
Directly within the project directory, enter the command `git init` (this creates the `.git/` directory—the repository).

### View the current status
`git status`

### Ignoring files
You want to ignore all compiled files (`.class` in the case of Java). Git will ignore (not track) all files identified in a file called `.gitignore` (you create this file yourself just inside the project directory:

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

### Staging untracked files
Examples:

```
git add .
git add *.java
git add README.md
```

### Committing files to the repository
#### Commit with a one-line commit message
For example, committing a new file:

`git commit -m "Initialize"`

#### Commit with a subject and body commit message
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

## Add a README.md
Each Git repository has at least one `README.md` file. Each subdirectory in the project hierarchy can have its own `README.md`.

## Renaming a file in Git
`git mv FibonacciSequence.java SequenceGenerator.java`

## Example of error, “Non-static method cannot be referenced from a static context”
Trying to run this code gives the “non-static” error:
```java
public class Sequences
{
    public void fibonacciSequence()
    {
	int i_2 = 1;		// The (i - 2)th term
	int i_1 = 1;		// The (i - 1)th term
	int i;			// The ith term

	// Print out the initial two terms
	System.out.print(i_2 + ", ");
	System.out.print(i_1 + ", ");

	// Compute and print the next 17 terms
	for (int n = 1; n <=17; n++)
	    {
		i = i_2 + i_1;
		System.out.print(i + ", ");
		i_2 = i_1;
		i_1 = i;
	    }

	// Print out the last term
	System.out.println(i_2 + i_1);
    }

    public static void main(String[] arguments)
    {
	
	fibonacciSequence();
    }
}
```
Why? Because in the `main` method, you're trying to invoke a *non-static* method (`fibonacciSequence`) as if it were static (i.e., there is no object instantiation, and you're not calling `fibonacciSequence()` on an object).

To make this right, you must either make `fibonacciSequence()` static, or else instantiate a `Sequences` object and call `fibonacciSequence` on that object. But notice that `Sequences` has no constructor, and also notice that it has no attributes (no state), so it appears, at least for the time being, it makes sense to leave the class as a *utility* (static) class. In that case, just make `fibonacciSequence` static, and you're good to go!

## Categorizing the input
When creating a program, a useful tip is to categorize the input into a finite number cases. Think about the input systematically (i.e., in order). For example, if the input is of type String, are strings of any length allowed? If so, start with the simplest case (i.e., the empty string), and work your way up. Maybe the empty string needs to be handled one way, and strings of length 1 or 2 must be handled a different way (but the same way as each other), and strings of length greater than 2 must be handled in yet a different way (but the same as each other).

## Java String substring method, length of substring
```
public String substring(int beginIndex,
                  int endIndex)
```
> Returns a new string that is a substring of this string. The substring begins at the specified `beginIndex` and extends to the character at index `endIndex - 1`. Thus, the length of the substring is `endIndex-beginIndex`.

**Question**: What if `endIndex` is out of bounds, as would be the case if the substring to be returned extended right to the end of this string (e.g., if this string is `"command"`, then `endIndex` would have to be 7 to return a substring that included the `d` at the end).

**Answer**: `endIndex` need not be interpreted as an index at all (perhaps the parameter name `endIndex` is misleading in this case). Here's a rephrasing of the method's description: "Returns the string composed of character(s) from index `beginIndex` up to but excluding the character at the index immediately preceding the integer `endIndex`."

Examples:
* `str.substring(0,6)` returns the string in `str` from characters 0 to 6, excluding 6 (namely, the characters from indeces 0 through 5 inclusive).
* `str.substring(1,2)` returns the string in `str` from characters 1 to 2, excluding 2 (namely, the character at index 1)
* `str.substring(1,1)` returns the string in `str` from characters 1 to 1, excluding 1 (namely, the empty string)

**Question**: How do they get the length to be `endIndex-beginIndex`?

**Answer**: First, note that the general length formula for a string is `j - (i - 1)`, where `i` is the index of the initial character of the string and `j` is the index of the final character of the string. Why is this the general string formula? Because `i` and `j` are both included in the string (length is all the characters in the string, including both the initial and final characters). The subtrahend is thus `i - 1` because we don't want to subtract `i` itself (it needs to be included); we want to subtract the character *before* `i` (i.e., `i - 1`).

Next, note that `substring(beginIndex, endIndex)` is defined such that `beginIndex` specifies the index of the initial character of the returned substring, and `endIndex` specifies the index of the character *immediately succeeding* the final character of the returned substring. Thus, the index of the final character of the returned substring is `endIndex - 1`.

Finally then, the length of the returned substring is `(endIndex - 1) - (beginIndex - 1)`, which simplifies to `endIndex - beginIndex`.

An important consequence is that if `beginIndex = endIndex`, the length of the returned substring is `0` (i.e., the returned substring is the empty string).

## Java check version

`java --version`

## Linux create a new (empty) file
<code>touch <var>filename</var></code>