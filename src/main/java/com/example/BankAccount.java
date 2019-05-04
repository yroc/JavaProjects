package com.example;

import java.lang.System;

/**
 * <p>A class that encapsulates a basic bank account
 *
 * <p> A bank account holds a balance and allow the client to make deposits and
 * withdraws. It is also capable of returning its current balance.
 */
public class BankAccount
{
    // Attributes
    private double balance;

    // Constructors
    /**
     * Constructs a bank account with the given initial balance
     *
     * @param     initialBalance
     *            The initial balance of this bank account
     */
    public BankAccount(double initialBalance)
    {
	this.balance = initialBalance;
	System.out.println("Your account was created with ");
	System.out.println(String.format("an initial balance of $%.2f", initialBalance));
    }

    // Methods
    /**
     * Deposits the given {@code amount} of money to this bank account
     *
     * @param     amount
     *            The amount of money to deposit into this bank account
     */
    public void deposit(double amount)
    {
	// Deposit amount
	this.balance = this.balance + amount;
	// Print confirmation message
	System.out.println("Your deposit of $" + amount + " was accepted");
	System.out.println("Your current balance is $" + this.balance);
    }

    /**
     * Withdraws the given {@code amount} of money from this bank account and
     * updates the balance accordingly. If there are insufficient funds in the
     * account (i.e., if {@code amount} exceeds {@code balance}), then no funds
     * are withdrawn, and a message is printed to the console informing the user.
     */
    public void withdraw(double amount)
    {
	if (amount <= this.balance)
	    {
		// Withdraw amount
		this.balance = this.balance - amount;
		// Print confirmation message
		String message1 = String.format("You have successfully withdrawn $%.2f from your account",
						amount);
		String message2 = String.format("Your current balance is $%.2f", this.balance);
		System.out.println(message1);
		System.out.println(message2);
	    }
	else  // amount > this.balance
	    {
		System.out.println("Withdraw unsuccessful; insufficient funds.");
		String message1 = String.format("You\u2019re trying to withdraw $%.2f", amount);
		String message2 = String.format("but your account only contains $%.2f", this.balance);
		System.out.println(message1);
		System.out.println(message2);
	    }
    }

    /**
     * Returns the current balance of this bank account as a string
     */
    public String toString()
    {
	return String.format("Current balance: $%.2f", this.balance);
    }
}
