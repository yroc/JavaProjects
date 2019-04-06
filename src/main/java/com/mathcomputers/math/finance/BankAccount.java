package com.mathcomputers.math.finance;

public class BankAccount
{
    // Attributes
    private double balance;

    // Constructors
    public BankAccount(double initialBalance)
    {
	this.balance = initialBalance;
    }

    // Methods
    public void deposit(double amount)
    {
	this.balance = this.balance + amount;
    }

    public void withdraw(double amount)
    {
	if (amount <= this.balance)
	    {
		this.balance = this.balance - amount;
	    }
	else
	    {
		System.out.println("Sorry, insufficient funds.");
		System.out.println(String.format("You are trying to withdraw $%.2f", amount));
		System.out.println(String.format("but your account only contains $%.2f", this.balance));
	    }
    }
  
    public String toString()
    {
	return String.format("After transactions, balance = $%.2f", this.balance);
    }
}
