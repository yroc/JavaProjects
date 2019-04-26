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
## Requirements
### 1.0
Write a class that implements the “easier” methods of `java.lang.String`.
### Possible future versions
* Fully implement `java.lang.String`.

# StringManipulator
## Requirements
### 1.0
Write a class that encapsulates a “string manipulator”—an object that manipulates a given string in various ways.

In this initial version, `StringManipulator` includes a method called `frontBack`, which returns a new string where the first and last characters have been exchanged.

### Possible future versions
Add various additional string manipulation methods.