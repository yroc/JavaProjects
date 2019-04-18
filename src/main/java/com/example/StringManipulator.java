package com.example;

import java.lang.String;

/** A class that encapsulates a collection of string manipulation methods */

public class StringManipulator
{
    // Methods
    /** Given a string, returns a new string where the first and last characters
     * have been exchanged */
    public static String frontBack(String str)
    {
	if (str.length <= 1)
	    {
		return str;
	    }
