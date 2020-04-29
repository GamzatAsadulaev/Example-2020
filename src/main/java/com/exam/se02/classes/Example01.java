package com.exam.se02.classes;


import com.exam.se02.generic.Queue;

import java.util.Iterator;

public class Example01 {
    public static void main(String[] args) {
        queue();


    }

    private static void queue() {
        Queue<String> queue = new LinkedQueue<>();
        queue.put("a");
        queue.put("b");
        queue.put("c");

        Iterator<String> iterator = queue.iterator();

        queue.poll();

        //assert  queue.isEmpty();
        System.out.println(iterator.next());
    }
}
