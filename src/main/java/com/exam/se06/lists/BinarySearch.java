package com.exam.se06.lists;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BinarySearch {
    //search([0, 1, 2, 4, 4, 5, 5, 7, 8], 6)
    //[0, 1, 2, 4, 4, 5, 5, 7, 8]
    //[               5, 5, 7, 8]
    //[                     7, 8]
    //[                   ^     ]

    private int pos = 0;
    //private int posElement = 0;

    static <T extends Comparable<T>> int search(List<? extends T> data, T element) {

        for(int start = 0, end = data.size(), mid; start < end; ) {
            mid = start + ((end - start) >> 1);

            int resultComparing = element.compareTo(data.get(mid));
            if(resultComparing == 0) {
                return mid;
            } else if (resultComparing < 0) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }


    <T extends Comparable> int searchMy(List<T> data, T element) {
        if(data.size() != 0) {
            int posElement = data.size() / 2;
            T value1 = data.get(posElement);
            Iterator<T> iterator = data.iterator();

            if(value1.equals(element)) {
                return pos + posElement;
            } else if (element.compareTo(value1) < 0) {

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(0, 1, 2, 4, 4, 5, 5, 7, 8);
        int result = search(values, 6);

    }



}
