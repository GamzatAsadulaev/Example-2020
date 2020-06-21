package com.exam.se06.lists;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LikedListExample {
    /**
     * O(1)              size()
     * O(1) ~ O(n)       contains(E)
     * O(1) ~ O(n/2)     get(index)
     * O(1) ~ O(n/2)     set( index, E)
     * O(1) ~ O(n)       remove(E)
     * O(1) ~ O(n/2)     remove(index)
     * O(1)              removeLast()
     * O(1)              removeFirst()
     * O(1)              add(E) ==  addLast(E)
     * O(1)              addFirst(E)
     * O(1) ~ O(n/2)     add(index, E)
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LinkedList<String> strings = new LinkedList<>();
        //[]

        strings.add("1");
        //[null<-"1"->null]
//                ^
//                &
        strings.add("2");
        //[null<-"1"->, "2"->null]
//                ^
//                       &
        strings.add("3");
        //[null-"1"->,<-"2"->,<-"3"->null]
//               ^
//                               &
        strings.add("hello");
        //[null-"1"->,<-"2"->,<-"3"->,,<-"hello"->null]
//               ^
//                                          &

        strings.addFirst("world");
        //["world", "1", "2", "3", "hello"]



    }
}
