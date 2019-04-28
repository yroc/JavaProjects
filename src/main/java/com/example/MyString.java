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

  public MyString() { this.value = new char[0]; }

    public MyString(char[] value)
    {
	this.value = Arrays.copyOf(value, value.length);
    }
}
