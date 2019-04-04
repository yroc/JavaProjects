package com.mathcomputers.math;

import java.util.Set;
import java.util.TreeSet;

public class Addends
{
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
	Set<Integer> set = new TreeSet<Integer>();
	set.add(1);
	set.add(2);
	set.add(17);
	set.add(5);
	set.add(6);

	int sum = 23;

	System.out.println(addends(set, sum));
    }
}
