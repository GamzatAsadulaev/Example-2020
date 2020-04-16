package com.exam.generic;
import java.util.Comparator;
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
        Queue<String> queue = new ArrayQueue<String>();
        assert queue.isEmpty();
        System.out.println("Test1 passed");
    }

    public static void test2() {
        Queue<String> queue = new ArrayQueue<>();


        try {
            String value =  queue.peek();
            assert false;
        } catch (Exception ex) {
            assert ex instanceof NoSuchElementException;
        }
        System.out.println("Test2 passed");
    }

    public static void test3() {
        Queue queue = new ArrayQueue();

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
        Queue<Integer> queue = new ArrayQueue<>();

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
        Queue<Integer> queue = new ArrayQueue<>();

        int value = 1;
        queue.put(value);
        Object result = queue.poll();

        assert result.equals(value);
        assert queue.isEmpty();

        System.out.println("Test5 passed");
    }


    private static void test6() {
        Queue<Integer> queue = new ArrayQueue<>();

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
        Queue<String> queue = new ArrayQueue<>();

        String str = "123";

        queue.put(str);
        String result1 = (String) queue.poll();
        assert result1.length() == 3;
        assert queue.isEmpty();

        System.out.println("Test7 passed");
    }

    private static void test8() {
        Queue<String> queue = new ArrayQueue<>();

        String str = "123";

        queue.put(str);

        devilMethod(queue);

        String result1 = queue.poll();
        assert result1.length() == 3;
        assert queue.isEmpty();

        System.out.println("Test8 passed");
    }

    private static void devilMethod(Queue<String> queue) {
        queue.poll();
        //queue.put(1);
    }

    private static void test9() {
        Queue<String> queue = new ArrayQueue<>();
        isEmpty(queue);

        Queue<Integer> integerQueue = new ArrayQueue<>();
        isEmpty(integerQueue);

    }

    private static boolean isEmpty(Queue<?> queue){
//        queue.put(1123);
//        queue.put("1123");
//        queue.put(new Thread());
//        queue.put(new Object());

//        queue.put(null);
        return queue.isEmpty();
    }

    private static void test10() {
        Queue<String> stringQueue = new ArrayQueue<>();
        stringQueue.put("1");
        stringQueue.put("12");
        stringQueue.put("023");

        String max = max(stringQueue);

        assert max.equals("023");
        System.out.println("Test10 passed");
    }

    private static <T extends Comparable<T>> T max(Queue<T> queue) {
        T result = queue.poll();

        while(queue.isEmpty()) {
            T curr = queue.poll();
            if(result.compareTo(curr) < 0) {
                result = curr;
            }
        }
        return result;
    }

    private static <T> T max (Queue<T> queue, Comparator<T> comparator) {
        T result = queue.poll();
        while (!queue.isEmpty()) {
            T curr = queue.poll();
            if(comparator.compare(result, curr) < 0) {
                result = curr;
            }
        }
        return result;
    }




//    class NumberOptional <T extends Number & Cloneable & Comparable<T>> {
//        private T value;
//
//        public NumberOptional(T value) {
//            value.compareTo(value);
//            this.value = value;
//        }
//
//
//        public T getValue() {
//            return value;
//        }
//
//        public void setValue(T value) {
//            this.value = value;
//        }
//    }


    class StringByLengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }

}
