package com.exam.classes;
import com.exam.generic.Queue;

import java.util.NoSuchElementException;
public class QueueTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();


    }

    public static void test1() {
        Queue<String> queue = new LinkedQueue<String>();
        assert queue.isEmpty();
        System.out.println("Test1 passed");
    }

    public static void test2() {
        Queue<String> queue = new LinkedQueue<>();


        try {
            String value =  queue.peek();
            assert false;
        } catch (Exception ex) {
            assert ex instanceof NoSuchElementException;
        }
        System.out.println("Test2 passed");
    }

    public static void test3() {
        Queue queue = new LinkedQueue();

        try {
            queue.poll();
            assert false;
        } catch (Exception ex) {
            assert ex instanceof NoSuchElementException;
        }
        System.out.println("Test3 passed");
    }

    public static void test4() {
        // prepare
        Queue<Integer> queue = new LinkedQueue<>();

        // run
        int value = 1;
        queue.put(value);
        Object result = queue.peek();

        // asserts
        assert result.equals(value);
        assert !queue.isEmpty();

        System.out.println("Test4 passed");
    }

    public static void test5() {
        Queue<Integer> queue = new LinkedQueue<>();

        int value = 1;
        queue.put(value);
        Object result = queue.poll();

        assert result.equals(value);
        assert queue.isEmpty();

        System.out.println("Test5 passed");
    }


    private static void test6() {
        Queue<Integer> queue = new LinkedQueue<>();

        int value1 = 1;
        int value2 = 2;

        queue.put(value1);
        queue.put(value2);
        Object result1 = queue.poll();
        Object result2 = queue.poll();

        assert result1.equals(value1);
        assert result2.equals(value2);
        assert queue.isEmpty();

        System.out.println("Test6 passed");
    }

    private static void test7() {
        Queue<String> queue = new LinkedQueue<>();

        String str = "123";

        queue.put(str);
        String result1 = (String) queue.poll();
        assert result1.length() == 3;
        assert queue.isEmpty();

        System.out.println("Test7 passed");
    }

    private static void test8() {
        Queue<String> stringQueue = new LinkedQueue<>();

        String str = "123";
        stringQueue.put(str);

        devilMethod(stringQueue);

        String result1 = stringQueue.poll();

        assert result1.length() == 3;
        assert stringQueue.isEmpty();

        System.out.println("Test8 passed");
    }



    private static void devilMethod(Queue<String> queue) {
        queue.poll();
        //queue.put(1);
    }

    abstract class MyNumber1 extends Number implements Cloneable, Comparable {

    }

    abstract class MyNumber2 extends Number implements Cloneable, Comparable {

    }

    class NumberOptional <T extends Number & Cloneable & Comparable<T>> {
        private T value;

        public NumberOptional(T value) {
            value.compareTo(value);
            this.value = value;
        }


        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    private static void test9() {
        Queue<String> queue = new LinkedQueue<>();
        isEmpty(queue);

        Queue<Integer> integerQueue = new LinkedQueue<>();
        isEmpty(integerQueue);


        System.out.println("Test8 passed");
    }

    private static void test10x() {

    }

    private static boolean isEmpty(Queue<?> queue){
//        queue.put(1123);
//        queue.put("1123");
//        queue.put(new Thread());
//        queue.put(new Object());

//        queue.put(null);
        return queue.isEmpty();
    }


}
