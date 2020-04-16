package com.exam.override;

public class Example01 {
    public static void main(String[] args) {
        A var1 = new A();
        var1.showInfo(1);

        A var2 = new B();
        var2.showInfo(2);

    }
}

class A {
    public static void showInfo(int val) {
        System.out.println("Static method of a BASE CLASS");
    }
    public void showInfo(double val) {

    }
}

class B extends A {
    public static void showInfo(int val) {
        System.out.println("Static method of a CHILD CLASS");
    }
    @Override
    public void showInfo(double val) {
        System.out.println("Non-static method of a CHILD CLASS");
    }
}
