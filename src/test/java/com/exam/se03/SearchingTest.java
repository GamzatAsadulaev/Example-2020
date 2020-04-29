package com.exam.se03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchingTest {
    @Test
    void indexOfString() {
        String original = "12345671";
        int result = original.indexOf('1');
        assertEquals(0, result);
        assertEquals(7, original.indexOf('1',result + 1));
        assertEquals(1, original.indexOf("234"));
    }

    @Test
    void testTrim() {
        assertEquals("1 2", " 1 2 ".replace('\u00A0', ' ').trim());
        assertEquals("", "\r\n".trim());
        assertEquals("1 2", "1 2 ".trim());
    }

    @Test
    void matches() {
        String input = "12321,2323";
        assertTrue(input.matches("^\\d+,\\d+$")); //регулярное выражение ("^\\d+,\\d+$")

    }

    @Test
    void split() {
         String input = "123,2, 3,  4, 5";
        String[] parts = input.split(", *");

        assertArrayEquals(new String[] {"123", "2", "3", "4", "5"}, parts);
    }

    @Test
    void splitWithLimit() {
         String input = "123,2, 3,  4, 5";
        String[] parts = input.split(", *", 5);

        assertArrayEquals(new String[] {"123", "2", "3", "4", "5"}, parts);
    }

    @Test
    void splitStar() {
        String input = "1,2";
        String[] parts = input.split(",");

        assertArrayEquals(new String[] {"1", "2"}, parts);
    }

}
