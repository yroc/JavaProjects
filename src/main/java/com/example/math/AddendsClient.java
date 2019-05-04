package com.example.math;

import java.util.Set;
import java.util.TreeSet;

/**
 * Client of the {@code MathGames.addends()} app
 */
public class AddendsClient
{
    public static void main(String[] arguments)
    {
	// Interactive version of addends
	//MathGames.addends();

	// Calling addends as a client
	Set<Integer> set = new TreeSet<Integer>();
	set.add(2);
	set.add(5);
	set.add(13);
	set.add(18);
	set.add(29);
	int sum = 47;
	Set<Integer> pair = MathGames.addends(set, sum);
	System.out.println(pair.toString());
    }
}
