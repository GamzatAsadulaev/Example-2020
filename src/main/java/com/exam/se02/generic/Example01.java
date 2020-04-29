package com.exam.se02.generic;

public class Example01 {
    public static void main(String[] args) {
        Queue<Number> numberQueue = new ArrayQueue<>();
        numberQueue.put(1);
        Number value = numberQueue.poll();

        // Producer
        // Extends
        // Consumer
        // Super

        //Producer
        //Extends
        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>();
        Queue<? extends Number> numberChildQueue1 = integerArrayQueue;

        Queue<? super Number> numberParentQueue = new ArrayQueue<Number>();
        //ArrayQueue<Object>

        Integer poll = integerArrayQueue.poll();


        //((ArrayQueue<Integer>)queue).put(12345);
        //.out.println(queue.peek());
    }

    private static Number sum(Queue<? extends Number> queue) {
        double result = 0;
        while(!queue.isEmpty()) {
            result +=queue.poll().doubleValue();
        }
        return result;
    }
}
