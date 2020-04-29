package com.exam.se01.recursion;

public class Example03 {
    public static long reverse(long value) {
        return Long.parseLong(new StringBuilder(String.valueOf(value)).reverse().toString());
    }
}
