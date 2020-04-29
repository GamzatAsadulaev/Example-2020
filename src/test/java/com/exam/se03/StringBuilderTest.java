package com.exam.se03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringBuilderTest {
    public static final int DEFAULT_CAPACITY_BUILDER = 16;

    @Test
    void testCapacity() {
        StringBuilder builder = new StringBuilder("123");

        assertEquals(3, builder.length());
        assertEquals(DEFAULT_CAPACITY_BUILDER + 3, builder.capacity());

        builder.append("12345678901234567");
        assertEquals(20, builder.length());
        assertEquals(40, builder.capacity());

        builder.delete(0, builder.length());
        assertEquals(0, builder.length());
        assertEquals(40, builder.capacity());
    }
}
