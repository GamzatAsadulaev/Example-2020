package com.exam.se02.other;

public class Example01 {
    public static void main(String[] args) {

    }
}


class A {
    public void show() {
        System.out.println("Hello World!");
    }
}

class B extends A{
    @Override
    public void show() {
        super.show();
    }
}