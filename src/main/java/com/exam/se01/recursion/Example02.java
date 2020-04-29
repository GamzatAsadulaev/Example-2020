package com.exam.se01.recursion;

public class Example02 {


    public static void method(int value) {
        System.out.println("Before: " + value--);
        if(value != 0) {
            method(value);
        }
        System.out.println("After: " + value);
    }

    public static void main(String[] args) {
        method(5);
    }


}
