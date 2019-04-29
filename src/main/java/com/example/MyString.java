/*
 * Copyright (c) 1994, 2018, Oracle and/or its affiliates. All rights
 * reserved. ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to licence terms.
 *
 */

package com.example;

import java.util.Arrays;

/**
 * <p>The {@code String} class represents character strings. All string literal
 * in Java programs, such as {@code "abc"}, are implemented as instances of this
 * class.
 *
 * <p>Strings are constant; their values cannot be changed after they are
 * created. String buffers support mutable strings.
 *
 * <p>The Java language provides special support for the string concatenation
 * operator (&nbsp;+&nbsp;) and for conversion of other objects to strings. For
 * additional information on string concatenation and conversion, see <i>The
 * Java&trade; Language Specification</i>.
 *
 * @implNote The implementation of the string concatenation operator is left to
 * the discretion of the Java compiler, as long as the compiler ultimately
 * conforms to the <i>Java&trade; Language Specification</i>. For example, the
 * {@code javac} compiler may implement the operator with {@code StringBuffer},
 * {@code StringBuilder}, or {@code java.lang.invoke.StringConcatFactory},
 * depending on the JDK version. The implementation of string conversion is
 * typically through the method {@code toString}, defined by {@code Object} and
 * inherited by all classes in Java.
 *
 * @author Arthur van Hoff
 * @author Martin Buchholz
 * @see    java.lang.Object#toString()
 * @see    java.lang.StringBuffer
 * @since  1.0
 * @jls    15.18.1 String Concatenation Operator +
 */

public final class MyString
{
    // Attributes
    /**
     * The value is used for character storage.
     */
    private final char[] value;

    // Constructors
    /**
     * Initializes a newly-created {@code String} so that it represents an empty
     * character sequence. Note that the use of this constructor is unnecessary
     * since Strings are immutable.
     */
    public MyString()
    {
	this.value = new char[0];
    }

    /**
     * Allocates a new {@code String} so that it represents the sequence of
     * characters currently contained in the character array argument. The
     * contents of the character array are copied; subsequent modification of
     * the character array does not affect the newly-created string.
     *
     * @param value
     *        The initial value of the string
     */
    public MyString(char[] value)
    {
	this.value = Arrays.copyOf(value, value.length);
    }

    // Methods
    /**
     * Returns the length of this string. The length is equal to the number of
     * <a href="Character.html#unicode">Unicode code units</a> in the string.
     *
     * @return the length of the sequence of characters represented by this object.
     */
    public int length()
    {
	return this.value.length;
    }

    /**
     * Returns {@code true} if, and only if, {@link #length()} is {@code 0}.
     *
     * @return {@code true} if {@link #length()} is {@code 0}, otherwise {@code
     * false}
     *
     * @since 1.6
     */
    public boolean isEmpty()
    {
	return this.value.length == 0;
    }

    /**
     * Returns {@code char} value at the specified index. An index ranges from
     * {@code 0} to {@code length() - 1}. The first {@code char} value of the
     * sequence is at index {@code 0}, the next at index {@code 1}, and so on,
     * as for array indexing.
     *
     * @param      index  the index of the {@code char} value.
     * @return     the {@code char} value at the specified index of this string.
     *             The first {@code char} value is at index {@code 0}.
     * @exception  IndexOutOfBoundsException if the {@code index} argument is
     *             negative or not less than the length of this string.
     */
    public char charAt(int index)
    {
	if ((index < 0 || index >= this.value.length))
	    {
		throw new IndexOutOfBoundsException(index);
	    }
	return this.value[index];
    }
 }
