/* Copyright (c) 2019 Cory Sand. All rights
 * reserved. CONFIDENTIAL/PROPRIETARY. */

package com.example.math;

import java.lang.System;
import java.lang.Integer;
import java.util.Set;
import java.util.TreeSet;

/**
 * A class that encapsulates a collection of math games
 * @author corsandy
 * @since 1.0
 */

public class MathGames
{
    // Methods
    /**
     * <p>Simulates the children's game fizz buzz (a group word game to teach them
     * about division).
     *
     * <p>Prints out the first n terms that would be generated when playing fizz
     * buzz. In this variation, the child says "fizzbuzz" in place of the number
     * if that number is a multiple of both five and seven, "fizz" in place of
     * the number if it's a multiple of five (but not seven), and "buzz" in
     * place of the number if it's a multiple of seven (but not
     * five). Otherwise, the child just says the number.
     *
     * <p>Each element in the sequence should be separated by a comma followed
     * by a space, except the last element, which should be terminated with a
     * period.
     */
    public static void fizzbuzz(int n)
    {
	// Consider the sequence 1, 2, ..., n. Let i represent each term in
	// this sequence in order starting from 1.

	for (int i = 1; i <= n; i++)
	    {
		if (i < n) // print a comma and space after the term
		    {
			if ( (i % 5 == 0) && (i % 7 == 0) )
			    {
				System.out.print("fizzbuzz, ");
			    }
			else if ( (i % 5 == 0) && (i % 7 != 0) )
			    {
				System.out.print("fizz, ");
			    }
			else if ( (i % 7 == 0) && (i % 5 != 0) )
			    {
				System.out.print("buzz, ");
			    }
			else // (i % 5 != 0) && (i % 7 != 0)
			    {
				System.out.print(i + ", ");
			    }
		    }
		if (i == n) // print a period and newline after the term
		    {
			if ( (i % 5 == 0) && (i % 7 == 0) )
			    {
				System.out.println("fizzbuzz.");
			    }
			else if ( (i % 5 == 0) && (i % 7 != 0) )
			    {
				System.out.println("fizz.");
			    }
			else if ( (i % 7 == 0) && (i % 5 != 0) )
			    {
				System.out.println("buzz.");
			    }
			else // (i % 5 != 0) && (i % 7 != 0)
			    {
				System.out.println(i + ".");
			    }
		    }
	    }
    }

    public static Set<Integer> addends(Set<Integer> set, int sum)
    {
	// Construct a set to hold the addends (if they exist) or else
	// the empty set
	Set<Integer> pair = new TreeSet<Integer>();

	for (int i : set)
	    {
		for (int j : set)
		    {
			if (i != j && i + j == sum && pair.size() == 0)
			    {
				pair.add(i);
				pair.add(j);
			    }
		    }
	    }
	return pair;
    }

    public static void main(String[] arguments)
    {
	int n = Integer.parseInt(arguments[0]);
	// fizzBuzz()
	MathGames.fizzbuzz(n);

	// addends()
	Set<Integer> set = new TreeSet<Integer>();
	set.add(1);
	set.add(2);
	set.add(17);
	set.add(5);
	set.add(6);

	int sum = 23;

	//System.out.println(addends(set, sum));
    }
}
