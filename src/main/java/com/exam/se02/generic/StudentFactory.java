package com.exam.se02.generic;

@FunctionalInterface
public interface StudentFactory {
    Student create(int weght, int age, String name, int course);
}
