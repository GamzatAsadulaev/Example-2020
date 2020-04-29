package com.exam.se01.recursion;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Example1 {
    //private int value;


    // Xss5
    // Прямая рекурсия
    public static void method(int value) {
        System.out.println("Before: " + value--);
        if(value != 0) {
            method(value);
        }
        System.out.println("After: " + value);
    }

    /**
     * Хвоставая рекурсия:
     * Рекурсия является хвостовой когда она выполняет какие то действия сверху и сам конце вызывает саму себя
     * @param value
     */
//    public static void method(int value) {
//        System.out.println("Before: " + value--);
//        if(value != 0) {
//            method(value);
//        }
//    }


}

class Launcher {
    public static void main(String[] args) {
        Example1.method(5);
    }
}
