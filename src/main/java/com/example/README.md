# BankAccount
## Requirements
### 1.0
Write a console app that consists of a class that encapsulates a bank account. The bank account must be able to hold a balance and be capable of performing the following banking activities:
* Opening an account with a specified initial balance.
* Depositing a specified amount of money into the account and accurately updating the balance.
* Withdrawing a specified amount of money from the account and accurately updating the balance. If there are insufficient funds in the account, the bank account should not withdraw the funds (i.e., not update the balance) and instead print the following to the console:
```
Withdraw unsuccessful; insufficient funds.
You are trying to withdraw $x.xx
but your account only contains $x.xx
```
* Print the current balance to the console in the form `The current balance of this account is $x.xx`.

Write client code to test the class.
### Possible future versions
* Make the app interactive. When started, the app should display the following prompt: `What would you like to do? (Enter ? for options)` If the user enters `?`, the app should display:
```
Options:
c, create account
d, deposit money
w, withdraw money
p, print current balance
```
* Incorporate a validation mechanism to deal with invalid entries (e.g., negative number or non-number input for deposits or withdraws).

# MyString
For pedagogical purposes, write the `java.lang.String` class—call it `MyString`.
## Requirements
### 1.0
Write a small subset of `java.lang.String`. This version should include (in order)
1) A copyright notice (as a regular comment)
2) A package declaration (reflecting the fake package `com.example`)
3) An `import` statement that imports `java.util.Arrays`
4) A Javadoc comment introducing the `String` class
5) The class header
6) An attribute reflecting the fact that a `String` object is a `char` array (with accommpanying Javadoc)
7) A constructor that instantiates an empty string (with accompanying Javadoc)
8) A constructor that instantiates a string from a `char` array (with accompanying Javadoc)
9) The `length` method (with accompanying Javadoc)
10) The `isEmpty` method (with accompanying Javadoc)
11) The `charAt` method (with accompanying Javadoc)
### Possible future versions
* Fully implement `java.lang.String`.
## Notes
### A `String` object is a `char` array
At least up until Java 8, the “underlying data structure” of a `String` was a `char` array (after Java 8 they switched to a `byte` array for unknown reasons). Here are several things to note about this:
* The individual characters of a `String` are `char`s. So the `String` method `charAt`, which returns the `char` at the specified index makes sense.
* Similarly, the methods `codePointAt` and `codePointBefore`, which return the Unicode code point (as an `int`) at the specfied (or before the specified) index make sense.
* Similarly, the constructor `String(char[] value)` makes sense.
* This does not mean that `String`s and `char` arrays are the same thing. `String`s have a large number of `String` *methods* that aren't available to `char` arrays. Actually, even though arrays are considered objects in Java (see JLS §4.3.1), arrays don't have methods commonly associated with “objects” in the traditional sense (i.e., class instances). That said, all methods of class `Object` may be invoked on an array, and arrays may be asigned to variables of type `Object`. In addition, there is a `java.util.Arrays` utility class that contains many methods for operating on arrays.

### Declaring an array variable
An array can hold any primitive type. The syntax for declaring an array variable is almost the same as for declaring a “regular” variable—just add brackets in front of the type, e.g.,:

`private char[] charArr     // declaring a (private) char array called "charArr"`

It's a common beginner mistake to confuse declaring an array variable with actually creating an array. Declaring an array variable does not actually create an array. That is,

`private char[] charArr`

does not create a `char` array; it merely tells the compiler that `charArr` is legally able to hold a reference to a `char` array. You still have to actually create the array (the creation process generates a reference, which can then be assigned an an array variable of the correct type).

### Creating an array
You can create an array with the `new` keyword:

`charArr = new char[10]     // create a char array with a capacity to hold 10 chars, and assign its reference to charArr (a previously-declared char array)`

Note that creating an array this way doesn't place any elements in it (the array has a *capacity* of 10, but it's still “empty”).

An alternative way of creating an array allows you to place elements in it at the same time you create it:

`charArray` = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'}

Note that with this way of creating an array, the length is specified *implicitly* (by the number of elements specified).

### String constructor from `char` array
When constructing a string from a `char` array, why make a copy of the argument array? That is, why do:

```java
public String(char[] value)
{
  this.value = Arrays.copyOf(value, value.length);
}
```

instead of the simpler:

```java
public String(char[] value)
{
  this.value = value;
}
```

Answer: If you do `this.value = value`; then the newly-constructed string will reference the same array as `value`. This means if `value` is changed (which it can be, as arrays are mutable), then the string will change! (not good, especially since `String` is supposed to be an immutable type!).

### Accessing array length
Eve though arrays are not mentioned in the Java API, they are still considered to be objects in Java (JLS§4.3.1, §10), and as such they can have attributes and methods. As it turns out, arrays have exactly *one* attribute: `length` (JLS§10.7, Array Members). An array's length can be accessed with the usual object-oriented syntax, e.g., `charArray.length`.

### Viewing Java API source code
There's nothing magical about the Java API source files (e.g., `String.java`)—they're all included in the JDK root directory (e.g., `jdk-11.0.2`), and it's just a matter of finding them (i.e., which subdirectories they're stored in). The general procedure is:

1. If necessary, download the Java JDK gzip from Oracle (e.g., `jdk-11.0.2_linux-x64_bin.tar.gz`)
2. Extract the downloaded `tar.gz` file to a convenient place (e.g., `~/`)
3. `cd` to `~/jdk-11.0.2/lib/`, where you should find `src.zip`—the archive that contains the source code for the Java platform
4. Unzip `src.zip`. This will create a several dozen directories that begin with either `java` or `jdk`.
5. `cd` to `java.base/`, which contains the package namespace directory `java/lang/` (corresponding to the package name `java.lang`)
6. `cd` to `java/lang/`. There you will find all of the Java API types in the `java.lang` package, including `String.java`, `StringBuilder.java`, `Object.java`, `Math.java`, `System.java`, and `Comparable.java`.

# StringManipulator
## Requirements
### 1.0
Write a class that encapsulates a “string manipulator”—an object that manipulates a given string in various ways.

In this initial version, `StringManipulator` includes a method called `frontBack`, which returns a new string where the first and last characters have been exchanged.

### Possible future versions
Add various additional string manipulation methods.
## Notes
### String substring method, length of substring
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
