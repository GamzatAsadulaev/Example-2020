package com.exam.se03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void createStudent() {
        Student result = Student.builder()
                .age(24)
                .name("Ivan")
                .name("Ivanov")
                .build();

        ;

    }
}