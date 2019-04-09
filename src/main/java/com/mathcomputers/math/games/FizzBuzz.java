package com.mathcomputers.math.games;

import java.lang.System;

/** This program plays the game "FizzBuzz". It counts to 100, replacing each
 *  multiple of 5 with the word "fizz", each multiple of 7 with the word "buzz",
 *  and each multiple of both with the word "fizzbuzz".
 **/

public class FizzBuzz
{
    public static void main(String[] arguments)
    {
	int counter = 1;
	while (counter <= 100)
	    {
		if ((counter % 5 == 0) && (counter % 7 == 0))
		    {
			System.out.print("fizzbuzz ");
		    }
		else if (counter % 5 == 0)
		    {
			System.out.print("fizz ");
		    }
		else if (counter % 7 == 0)
		    {
			System.out.print("buzz");
		    }
		else
		    {
			System.out.print(counter + " ");
		    }
		counter++;
	    }
    }
}
