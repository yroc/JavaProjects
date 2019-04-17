package com.example;

import java.lang.*;

/** A Java class that encapsulates a set of math games **/

public class MathGames
{
    public static void fizzBuzz()
    {
	for (int i = 1; i <= 100; i++)
	    {
		if (i % 7 == 0 && i % 5 == 0)
		    {
			System.out.print("fizzbuzz ");
		    }
		else if (i % 5 == 0)
		    {
			System.out.print("fizz ");
		    }
		else if (i % 7 == 0)
		    {
			System.out.print("buzz ");
		    }
		else
		    {
			System.out.print(i + " ");
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
			if (i != j && i + j = sum && pair.size() == 0)
			    {
				pair.add(i);
				pair.add(j);
			    }
		    }
	    }
	return pair;

    public static void main(String[] arguments)
    {
	// fizzBuzz()
	MathGames.fizzBuzz();

	// addends()
	Set<Integer> set = new TreeSet<Integer>();
	set.add(1);
	set.add(2);
	set.add(17);
	set.add(5);
	set.add(6);

	int sum = 23;

	System.out.println(addends(set, sum);
    }
}
