package com.example;

import java.util.Scanner;

/**
 * A console app that allows the user to perform various banking activities,
 * including creating accounts, and making deposits and withdraws.
 */
public class BankAccountConsole
{   
    public static void main(String[] arguments)
    {
	// Reference to a bank account
	BankAccount ba = null;
	// An amount of money to deposit or withdraw
	double amount;
	// A scanner to get user input (e.g., which banking activity to perform, how much to deposit)
	Scanner sc = new Scanner(System.in);
    
	System.out.println("Welcome to Banking USA.");
	String activity = activityPrompt(sc);

	while (activity != "e")
	    {
		if (activity.equals("?"))
		    {
			printOptions();
			activity = activityPrompt(sc);
		    }
		else if (activity.equals("c"))
		    {
			System.out.println("How much would you like to initially deposit to your new account?: ");
			double initialBalance = sc.nextDouble();
			ba = new BankAccount(initialBalance);
			activity = activityPrompt(sc);
		    }
		else if (activity.equals("d"))
		    {
			if (ba == null)
			    {
				System.out.println("You have to create a bank account first");
				activity = activityPrompt(sc);
			    }
			else
			    {
				System.out.print("OK, how much would you like to deposit? ");
				amount = sc.nextDouble();
				ba.deposit(amount);
				activity = activityPrompt(sc);
			    }
		    }
		else if (activity.equals("w"))
		    {
			if (ba == null)
			    {
				System.out.println("You have to create a bank account first");
				activity = activityPrompt(sc);
			    }
			else
			    {
				System.out.print("OK, how much would you like to deposit? ");
				amount = sc.nextDouble();
				ba.withdraw(amount);
				activity = activityPrompt(sc);
			    }
		    }
		else if (activity.equals("p"))
		    {
			if (ba == null)
			    {
				System.out.println("You have to create a bank account first");
				activity = activityPrompt(sc);
			    }
			else
			    {
				ba.toString();
				activity = activityPrompt(sc);
			    }
		    }
		else  // invalid option
		    {
			System.out.println("Invalid option entered.");
			System.out.println("");
			printOptions();
			activity = activityPrompt(sc);
		    }	
	    }
	
    }

    private static String activityPrompt(Scanner sc)
    {
	System.out.println("What would you like to do today? (Enter ? for options)");
	String activity = sc.nextLine();
	return activity;
    }
	
    private static void printOptions()
    {
	System.out.println("Options:");
	System.out.println("c create account");
	System.out.println("d deposit money");
	System.out.println("w withdraw money");
	System.out.println("p print current balance");
	System.out.println("e exit");
	System.out.println("");
    }
}
