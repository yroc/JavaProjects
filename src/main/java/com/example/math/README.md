# MathGames
## Requirements
### 1.0
Write a class that encapsulates methods that simulate various math games.

This intial version includes two methods: `fizzbuzz` and `addends`.

`fizzbuzz` simulates the children's division game *Fizz Buzz*:
>FizzBuzz is a game I learned long ago in elementary school French class as a way to practice counting in that language. The players take turns counting, starting with one and going up. The rules are simple: when your turn arrives, you say the next number. However, if that number is a multiple of five, you say "fizz" instead. If the number is a multiple of seven, you say "buzz." And if the number is a multiple of both, you say "fizzbuzz."

`fizzbuzz` should print out the first *n* terms that would be generated when playing *Fizz Buzz*. The value of `n` is passed to the app at the command line.

`addends` receives the set of integers `[1, 2, 5, 6, 17]` and the integer `23` and returns the pair of integers in the set that sum to 23 (namely, `6` and `17`).

### Possible future versions
* Modify `fizzbuzz` so that it allows the client to specify the number of terms to print.
* Modify `addends` so that it allows the client to specify any set of integers and any sum, and return any pair of integers in the set that add to the given sum.
* Add additional math games.

# MathSequenceGenerator
## Requirements
### 1.0
Write a class that encapsulates methods that generate various mathematical sequences.

This initial version includes a method called `fibonacci` that prints out the first 20 terms of the Fibonacci sequence (assume the initial two elements in the sequence is 1 and 1).
>The Fibonacci numbers are a sequence of numbers in which each successive number is the sum of the two preceding numbers. The first few numbers of the sequence are 1, 1, 2, 3, 5, 8, 13,… This sequence appears in interesting places in nature. For example, the number of petals on most species of flowers is one of the Fibonacci numbers.

#### Possible future versions
* Modify `fibonacci` so that it accepts user input specifying the number of terms to print
* Modify `fibonacci` so that it uses recursion to generate the terms of the sequence
* Add additional methods that print out various other mathematical sequences.


