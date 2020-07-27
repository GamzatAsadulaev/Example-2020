package com.exam.se06.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ColectionsTest {
    @Test
    void fillOnEmptyList() {
        List<String> list = new ArrayList<>();

        Collections.fill(list, "hello");

        assertTrue(list.isEmpty());
    }

    @Test
    void fillOnNotEmptyList() {
        List<String> list = Arrays.asList("1", "2", "3");

        Collections.fill(list, "hello");

        assertEquals(3, list.size());
        assertEquals("hello", list.get(0));
        assertEquals("hello", list.get(1));
        assertEquals("hello", list.get(2));

        assertEquals(Arrays.asList("hello", "hello", "hello"), list);
    }

    @Test
    void copyLists() {
        List<String> src = Arrays.asList("1", "2", "3");
        List<String> dst = Arrays.asList("1", "2", "3");

        Collections.copy(dst, src);
        assertEquals(src, dst);
    }

    @Test
    void minUsingNaturalOrder() {
//        Set<String> values = Set.of("abc", "cde", "1"); // Java9+ API
        Set<String> values = new HashSet<>(Arrays.asList("abc", "cde", "1234", "q"));
//        values.add("abc");
//        values.add("cde");
//        values.add("1234");

        String result = Collections.min(values);

        assertEquals("1234", result);
    }

    @Test
    void minUsingCustomOrder() {
        Set<String> values = new HashSet<>(Arrays.asList("abc", "cde", "1234", "q"));
        String result = Collections.min(values, Comparator.comparingInt(String::length));

        assertEquals("q", result);
    }

    @Test
    void rotateRight() {
        List<String> src = Arrays.asList("1", "2", "3");

        Collections.rotate(src,2 );
        assertEquals(Arrays.asList("2", "3", "1"), src);
    }

    @Test
    void rotateLeft() {
        List<String> src = Arrays.asList("1", "2", "3");

        Collections.rotate(src,-2 );
        assertEquals(Arrays.asList("3", "1", "2"), src);
    }

    @Test
    void indexOfSubList() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 2, 2, 3);

        int result = Collections.indexOfSubList(values, Arrays.asList(2, 3));

        assertEquals(1, result);

    }

    @Test
    void lastIndexOfSubList() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 2, 2, 3);

        int result = Collections.lastIndexOfSubList(values, Arrays.asList(2, 3));

        assertEquals(6, result);

    }

    @Test
    void swap() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 2, 2, 3);
        Collections.swap(values, 3, 4);
        assertEquals(Arrays.asList(1, 2, 3, 5, 4, 2, 2, 3), values);
    }


    @SuppressWarnings("ConstantConditions")
    @Test
    void unmodifiableCollection() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 2, 2, 3);

        List<Integer> unmodifiableList = Collections.unmodifiableList(values);

        assertThrows(UnsupportedOperationException.class, ()-> unmodifiableList.add(1));

    }

    @Test
    @SuppressWarnings("all")
    void checkedCollection() {
        //PECS
        List <Number> list = new ArrayList<>();
        List <Number> checked = Collections.checkedList(list, Number.class);

        List raw = checked;

        raw.add(1);
        assertThrows(ClassCastException.class, ()-> raw.add("c"));
    }

    @Test
    void reverseOrder() {
        List<Integer> values = Arrays.asList(1, 3, 6, 2, 4, 3);

        values.sort(Comparator.reverseOrder());

        assertEquals(Arrays.asList(6, 4, 3, 3, 2, 1), values);
    }
}
