package com.exam.se02.finalize;

public class Example01 {
    @Override
    protected void finalize() throws Throwable {
        while(true) {
            System.out.println("call's finalize");
        }
    }
}

class Launcher {
    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(10_000);
        Example01 emp01 = new Example01();


        System.out.println(emp01.toString());

        emp01 = null;

        Runtime.getRuntime().gc();

    }
}
