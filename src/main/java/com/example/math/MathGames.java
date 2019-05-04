/* Copyright (c) 2019 corsandy. All rights
 * reserved. CONFIDENTIAL/PROPRIETARY. */

package com.example.math;

import java.lang.System;
import java.lang.Integer;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

/**
 * A class that encapsulates a collection of math games
 * @author corsandy
 * @since 1.0
 */
public class MathGames
{
    /**
     * <p>Simulates the children's game fizz buzz (a group word game to teach
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
     *
     * @param n
     *        The number of terms in the sequence
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

    /**
     * Given a set of integers and an integer sum, returns a distinct pair of
     * integers (the "addends") in the set that add to the given sum. If no such
     * integers exist, returns the empty set.
     *
     * @param     set   the given set of integers
     * @param     sum   the given sum
     * @return    a set of two integers in {@code set} that add to {@code sum}. If
     *            no such set exists, returns the empty set.
     */
    public static Set<Integer> addends(Set<Integer> set, int sum)
    {
	// Construct a set to hold the addends (if they exist) or else the empty
	// set
	Set<Integer> pair = new TreeSet<Integer>();

	// Find two distinct integers from set that add to sum
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

    /**
     * Interactive version of {@code addends}. User is prompted at the console
     * for a set of integers and a sum. {@code addends} will print a set
     * containing the summands (if they exist) of the given set or else the
     * empty set
     */
    public static void addends()
    {
	// Construct a set to hold the integers from which the addends will be searched
	Set<Integer> set = new TreeSet<Integer>();

	// Construct a set to hold the addends (if they exist) or else the empty
	// set
	Set<Integer> pair = new TreeSet<Integer>();

	// Variable to hold the specified sum
	int sum;

	// Intro prompt
	System.out.println("In this program, you enter a set of integers and a sum,");
	System.out.println("and the program will return a pair of integers in the set");
	System.out.println("that add to sum. If no such integers in the set add to your sum,");
	System.out.println("the program will just return the empty set.");
	System.out.println("");
	// Prompt user to enter a set of integers
	System.out.println("First, enter your set.");
	System.out.println("Enter a few integers (space separated).");
	System.out.println("After the last one, type a space,");
	System.out.println("then a period, then press ENTER.");
	System.out.println("For example, to enter the set containing");
	System.out.println("the integers 2, 5, 13, 18, and 29, you would type in");
	System.out.println("2 5 13 18 29 .");
	System.out.println("followed by ENTER.");

	// Connect to keyboard and scan entries
	Scanner sc = new Scanner (System.in);
	while(sc.hasNextInt())
	    {
		set.add(sc.nextInt());
	    }

	// Flush scanner of residual period
	sc.nextLine();

	// Prompt user to enter an integer sum
	System.out.println("Now, enter your sum.");
	System.out.println("Type in an integer followed by the ENTER key.");

	// Scan inputted integer
	sum = sc.nextInt();

	// Find two distinct integers (if any) in the given set that add to sum
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
	System.out.println(pair.toString());
    }

}
