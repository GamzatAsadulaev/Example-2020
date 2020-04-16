package com.exam.generic;

@FunctionalInterface
public interface StudentFactory {
    Student create(int weght, int age, String name, int course);
}
