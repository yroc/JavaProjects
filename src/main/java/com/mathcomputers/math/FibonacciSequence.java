package com.mathcomputers.math;

public class FibonacciSequence
{
    public static void main(String[] arguments)
    {
	int i_2 = 1;		// The (i - 2)th term
	int i_1 = 1;		// The (i - 1)th term
	int i;			// The ith term

	// Print out the initial two terms
	System.out.print(i_2 + ", ");
	System.out.print(i_1 + ", ");

	// Compute and print the next 17 terms
	for (int n = 1; n <=17; n++)
	    {
		i = i_2 + i_1;
		System.out.print(i + ", ");
		i_2 = i_1;
		i_1 = i;
	    }

	// Print out the last term
	System.out.println(i_2 + i_1);
    }
}
