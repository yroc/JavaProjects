package com.example;

/**
 * A client of the BankAccount class
 */
public class BankAccountClient
{
    public static void main(String[] arguments)
    {
	BankAccount ba = new BankAccount(100);
	ba.deposit(76.35);
	ba.withdraw(200.00);
	System.out.println(ba.toString());
    }
}
