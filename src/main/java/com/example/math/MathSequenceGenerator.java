package com.example.math;

import java.lang.System;
import java.util.List;
import java.util.ArrayList;

/**
 * A class that encapsulates methods that generate various mathematical
 * sequences
 */

public class MathSequenceGenerator
{
    /**
     * Returns the first n terms of the Fibonacci sequence as a list.
     */
    public static List<Integer> fibonacci(int n)
    {
	int i_2 = 0;		// The (i - 2)th term
	int i_1 = 1;		// The (i - 1)th term
	int i;			// The ith term

	List<Integer> fib = new ArrayList<Integer>();
	fib.add(i_2);
	
	if (n == 1)
	    {
		return fib;
	    }

	fib.add(i_1);

	if (n == 2)
	    {
		return fib;
	    }

	for (int j = 3; j <= n; j++)
	    {
		i = i_2 + i_1;
		fib.add(i);
		i_2 = i_1;
		i_1 = i;
	    }

	return fib;
    }
}
