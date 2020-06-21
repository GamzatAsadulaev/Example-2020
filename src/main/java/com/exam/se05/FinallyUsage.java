package com.exam.se05;

public class FinallyUsage {

    public static void main(String[] args) {
        try {
            procA();
        } catch (Exception e) {
            System.out.println("Исключение выброшено");
        }
        procB();
        procC();

    }

    // Выход из метода через исключение
    static void procA() {
        try{
            System.out.println("Внутри procA");
            if (true) {
                throw new RuntimeException("demo");
            }
        } finally {
            System.out.println("finally ля procA ");
        }
        System.out.println("procA::after try");
    }

    // Возврат изнутри try-блока
    static int procB() {
        try{
            System.out.println("Внутри procB");
            return 10;
        } finally {
            System.out.println("finally для procB");
            return 20;
        }
    }

    // Нормальное выполнение блока try-блока
    static int procC() {
        try{
            System.out.println("Внутри procC");
            throw new RuntimeException("demo");
        } catch(RuntimeException ex) {
            return 50;
        } finally{
            System.out.println("finally для procC");
            throw new RuntimeException("dem2");

        }
    }


}
