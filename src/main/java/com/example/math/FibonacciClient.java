package com.example.math;

import java.lang.System;
import java.util.List;
import java.util.ArrayList;

public class FibonacciClient
{
    public static void main(String[] arguments)
    {
	List<Integer> fibonacci = new ArrayList<Integer>();
	fibonacci = MathSequenceGenerator.fibonacci(20);
	System.out.println(fibonacci.toString());
    }
}
