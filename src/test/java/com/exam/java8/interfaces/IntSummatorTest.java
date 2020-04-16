package com.exam.java8.interfaces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntSummatorTest {
    @DisplayName("Test sum method")
    @Test
    void test1() {
        IntSummator summator = new IntSummator();

        Integer result = summator.sum(1, 2);
        //Assertions.assertEquals(Integer.valueOf(3), result); //Object, Object
        assertEquals(3, result.intValue()); //int, int

    }

    @DisplayName("Test twice method")
    @Test
    void test2() {
        IntSummator summator = new IntSummator();

        Integer result = summator.twice(1);
        assertEquals(3, result.intValue());

    }
}