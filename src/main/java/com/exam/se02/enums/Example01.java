package com.exam.se02.enums;

public class Example01 {
    public static void main(String[] args) {
        Shape[] arr = Shape.values();
        for(Shape sh : arr) {
            System.out.println(sh + " " + sh.getColor());
        }
    }
}
