package com.exam.se06.lists;

import java.util.*;

public class ListIteratorExample {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListIterator<Integer> iterator = values.listIterator();

        System.out.println(iterator.nextIndex());
        iterator.add(-1);
        iterator.add(-2);
        iterator.add(-3);
        System.out.println(values);
        final String hehe = new String("hehe");




    }
}
