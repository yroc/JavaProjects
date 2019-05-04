package com.example.math;

import java.util.Set;
import java.util.TreeSet;

/**
 * <p>Console version of addends where input is supplied as command-line
 * arguments. A standalone class, {@code Addends} is needed in the case when
 * command line arguments are supplied because methods (e.g., {@code
 * MathGames.addends()}) cannot be called from the command line (only classes
 * can).
 *
 * <p>Addends is a program that takes as input a set of integers and an integer
 * sum, and returns a distinct pair of integers from the set that add to the
 * given sum. If no such integers exist, the empty set is returned.
 *
 * <p>Given n (space-delimited) command-line arguments, the first n - 1 are
 * interpreted as being part of the set of integers from which the addends are
 * searched, and the nth argument is interpreted as the given sum.
 */
public class Addends
{
    public static void main(String[] arguments)
    {
	// Construct a set to hold the set of integers from which the addends
	// are to be searched
       	Set<Integer> set = new TreeSet<Integer>();

	// Construct a set to hold the addends (if they exist) or else the empty
	// set
	Set<Integer> pair = new TreeSet<Integer>();

	// Place the first n - 1 arguments into the set 
	int length = arguments.length;
	for (int i = 0; i < length - 1; i++)
	    {
		set.add(Integer.parseInt(arguments[i]));
	    }

	// The nth command-line argument is the sum
	int sum = Integer.parseInt(arguments[length - 1]);

	// Try to find a pair of integers in the set that add to the sum
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

	// Print the pair of addends (or the empty set if no addends found)
	System.out.println(pair);
	}
}
