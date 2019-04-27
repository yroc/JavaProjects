package com.example;

import java.lang.String;

/** A class that encapsulates a collection of string manipulation methods */

public class StringManipulator
{
    // Attributes
    private String str;

    // Constructor
    public StringManipulator(String str)
    {
	this.str = str;
    }

    // Methods
    /** Given a string, returns a new string where the first and last characters
     * have been exchanged */
    public String frontBack()
    {
	if (this.str.length() <= 1)
	    {
		return this.str;
	    }

	// this.str.length() >= 2
	char firstChar = this.str.charAt(0);
	char lastChar = this.str.charAt(this.str.length() - 1);
	String middleChars = this.str.substring(1, this.str.length() - 1);
	return lastChar + middleChars + firstChar;
    }

    // PSVM test method
    public static void main(String[] arguments)
    {
	StringManipulator smEmpty = new StringManipulator("");
	StringManipulator smOne = new StringManipulator("a");
	StringManipulator smTwo = new StringManipulator("ab");
	StringManipulator smThree = new StringManipulator("abc");
	StringManipulator smFive = new StringManipulator("Float");

	System.out.println(smEmpty.frontBack() + ", ");
	System.out.println(smOne.frontBack() + ", ");
	System.out.println(smTwo.frontBack() + ", ");
	System.out.println(smThree.frontBack() + ", ");
	System.out.println(smFive.frontBack());
    }
}
