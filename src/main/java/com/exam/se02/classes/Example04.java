package com.exam.se02.classes;

import java.util.Date;

public class Example04 {
    public static void main(String[] args) {
        Date realDate = new Date();
        Date anonymousDate = new Date() {
            /**
             * Можно при переопределнии анонимного класса внутри создать методы или поля
             * Но к ним нельзя обратиться через сссылку, которая указывает на этот объект
             * Так как ссылка класса не знает ничего об этих полях и методах
             *
             */
            private int value;

            @Override
            public String toString() {
                return "Current time =" + super.toString();
            }

            private void method() {
                System.out.println("Method from anonymous class");
            }
        };
        System.out.println(anonymousDate);
        System.out.println(realDate);


    }
}

