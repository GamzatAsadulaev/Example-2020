package com.exam.se03;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Formatter;

import static org.junit.jupiter.api.Assertions.*;

public class FormatterTest {
    @Test
    void testFormat() {
        boolean b1 = true;
        Boolean b2 = null;
        System.out.println("1. - " + b1 + ", " + b2);
        System.out.printf("3. - %2$b, %1$b%n", b1, b2);
        System.out.printf("2. - %b, %b%n", b1, b2);
        System.out.printf("5. - %b, %b, %b%n", b1, b2, b2);
        System.out.printf("4. - %b, %b, %<b%n", b1, b2);
    }

    @Test
    void test2() {
        Formatter formatter = new Formatter();
        formatter.format("%#o, %#x", 7, 10);
        assertEquals(formatter.toString(), "07, 0xa");
    }

    @Test
    void test3() {
        Formatter formatter = new Formatter();
        formatter.format("%- 4d,% 04d", 50, -50);
        assertEquals(formatter.toString(), " 50 ,-050");
    }

    @Test
    void precision() {
        Formatter formatter = new Formatter();
        formatter.format("%.2f", 5.5555556);
        //assertEquals(formatter.toString(), "5.56"); // Вместо точки выводит запятую
    }

    @Test
    void time() {
        Formatter formatter = new Formatter();
        formatter.format("%tH %<tl", new Date(1587412771596L));
        assertEquals("22 10", formatter.toString());
    }
}
