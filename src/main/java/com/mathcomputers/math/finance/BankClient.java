package com.mathcomputers.math.finance;

public class BankClient
{
    public static void main(String[] args)
    {
	BankAccount ba = new BankAccount(100);
	System.out.println(String.format("Before transactions, balance = $%.2f", ba.getBalance()));
	ba.deposit(76.35);
	ba.withdraw(200.00);
	System.out.println(ba.toString());
    }
}
