package com.exam.se06.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Example01 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        List<Integer> subList = list.subList(1, 3);
        ListIterator<Integer> iterator = subList.listIterator();
        while(iterator.hasNext()) {
            iterator.next();
            iterator.set(2);

        }
        System.out.println(subList);
        System.out.println(list);

        subList.add(1, 3);
        System.out.println(list);
    }
}
