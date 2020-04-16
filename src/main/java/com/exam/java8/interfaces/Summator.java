package com.exam.java8.interfaces;


/**
 * Функциональный интерфейс
 * @param <T>
 */
@FunctionalInterface
public interface Summator <T> {


    /**
     * Чиствй метод который не зависит от состояния
     * Если интерфейс имеет чистый метод то он является функциональным интерфейсом
     * пример метод compare в интерфейсе Comparator
     * @param left
     * @param right
     * @return
     */
    T sum(T left, T right) ;

    default T twice(T value) {
        return sum(value, value);
    }

    static void method() {
        System.out.println("I'm static method from Summator");
    }
}
