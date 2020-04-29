package com.exam.se03;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RegexTest {

    @Test
    void matches() {
        String string = "123";
        String string2 = "a123";
        String regex = "\\d+";

        assertTrue(Pattern.matches(regex, string));
        assertTrue(string.matches(regex));
        assertFalse(Pattern.matches(regex, string2));
        assertFalse(string2.matches(regex));

    }

    @Test
    void compile() {
        Pattern regex = Pattern.compile("\\d+");

        String originalRegex = regex.pattern();
        assertEquals("\\d+", originalRegex);

        assertNotNull(regex);
    }

 
    @Test
    void patternMethods() {
        Pattern regex = Pattern.compile("\\d{2,}");

        String originalRegex = regex.pattern();
        assertEquals("\\d{2,}", originalRegex);

        Predicate<String> empty = String::isEmpty;
        Predicate<String> notEmpty = empty.negate();
        Predicate<String> startsWith1 = string -> string.startsWith("1");

        assertTrue(notEmpty.test("123"));
        assertFalse(notEmpty.test(""));


        Predicate<String> notEmptyAndStartsWith = notEmpty.and(startsWith1);
        assertTrue(notEmptyAndStartsWith.test("123"));
        assertFalse(notEmptyAndStartsWith.test("a123"));

        Predicate<String> matches = regex.asPredicate();

        List<String> result= Stream.of("1", "a", "123", "bbasd")
                .filter(matches)
                .collect(Collectors.toList());
        assertEquals(1, result.size());
        assertEquals("123", result.get(0));
    }

    @Test
    void split() {
        String source = "1, 2, 3, 4      , 6";

        String[] result1 = source.split(",\\s+");
        String[] result2 = Pattern.compile(",\\s+").split(source);

        assertArrayEquals(result1, result2);

        Pattern.compile("\\s+,\\s+")
                .splitAsStream(source)
                .map(string -> "_" + string)
                .forEachOrdered(System.out::println);

    }

    @Test
    void matcher() {
        Pattern regex = Pattern.compile("(\\w+)'(\\w+)");
        Matcher matcher = regex.matcher("Congrats on finishing the lessons! We hope that they've given you a bit more experience with regular expressions and how to apply them in everyday use.");
//        assertFalse(matcher.matches());

        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.start());
            System.out.println(matcher.group(1));
            System.out.println(matcher.start(1));
            System.out.println(matcher.end(1));
            System.out.println(matcher.group(2));
        }
        matcher.reset();
        System.out.println(matcher.hitEnd());
    }

    @Test
    void compileIncorrectRegex() {
        //assertThrows(PatternSyntaxException.class, ()->Pattern.compile("[]]"));
    }

    @Test
    void example() {
        String input1 = "123.232000";
        String input2 = "123.000000";
        String input3 = "123.002300";
        String input4 = "123.123456";

        String regex = "0*$";

        assertEquals(3 ,getZeroesAtTheEnd(input1, regex));
        assertEquals(6 ,getZeroesAtTheEnd(input2, regex));
        assertEquals(2 ,getZeroesAtTheEnd(input3, regex));
        assertEquals(0 ,getZeroesAtTheEnd(input4, regex));
    }

    private int getZeroesAtTheEnd(String input1, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(input1);
        if (matcher.find()) {
            return matcher.group().length();
        } return 0;
    }

    @Test
    void example2() {
        String input1 = "123.232000";
        String input2 = "123.000000";
        String input3 = "123.002300";
        String input4 = "123.123456";

        String[] split = Pattern.compile("\\d+\\.").split(input4);
        String[] split1 = split[1].split("0*[1-9]");
        for (String str : split1) {
            if(!"".equals(str)) {
                System.out.println(str.length());
            }
        }

        System.out.println(Arrays.toString(split1));

    }
}
