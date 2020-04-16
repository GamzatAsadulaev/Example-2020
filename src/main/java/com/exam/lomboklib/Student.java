package com.exam.lomboklib;

import lombok.*;

@Getter
@EqualsAndHashCode(exclude = {"name", "surname", "age"})
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private String surName;
    private int age;


}

class Launcher {
    public static void main(String[] args) {
        Student student = new Student(1, "Ruslan", "Frolof", 23);

        Student student1 = new Student(1, "Alexey", "Frolof", 23);

        System.out.println(student.equals(student));
    }
}