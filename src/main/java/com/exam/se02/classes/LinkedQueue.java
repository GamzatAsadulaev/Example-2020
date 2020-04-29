package com.exam.se02.classes;

import com.exam.se02.generic.Queue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {


    private Node<T> head;
    private int modCount = 0;

    @Override
    public void put(T value) {
        Node<T> added = new Node<>(value);
        if(isEmpty()) {
            head = added;
        } else {
            Node <T> curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = added;
        }
        ++modCount;
    }

    @Override
    public T poll() {
        if(isEmpty()) {
            throw  new NoSuchElementException();
        }
        T result = head.value;
        head = head.next;
        ++modCount;
        return result;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.value;
    }



    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        //return new LinquedQueueIterator<>(this);
        //return  new LinquedQueueIterator();
        /**
         * Анонимный класс имеет доступ к полям и методам внешнего класса оболочка
         * так как он объявлен внутри нестатического метода
         */
        return new Iterator<T>() {
            private Node<T> curr = head;// head - поле внешнего класса
            private int expectedModCount = modCount;// modCount - поле внешнего класса

            //private LinquedQueueIterator(LinkedQueue<T> queue) {
//          private LinquedQueueIterator() {
//              // Явное указание через класс обертки
//              //this.curr = LinkedQueue.this.head;
//              //expectedModCount = LinkedQueue.this.modCount;
//
//              this.curr = head;
//              expectedModCount = modCount;
//          }
            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                checkForComodification();
                T result = curr.value;
                curr = curr.next;
                return result;
            }

            private void checkForComodification() {
                if(expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };


    }

//    private class LinquedQueueIterator implements Iterator<T> {
//
//        private Node<T> curr = head;
//        private int expectedModCount = modCount;
//
//        //private LinquedQueueIterator(LinkedQueue<T> queue) {
////          private LinquedQueueIterator() {
////              // Явное указание через класс обертки
////              //this.curr = LinkedQueue.this.head;
////              //expectedModCount = LinkedQueue.this.modCount;
////
////              this.curr = head;
////              expectedModCount = modCount;
////          }
//        @Override
//        public boolean hasNext() {
//            return curr != null;
//        }
//
//        @Override
//        public T next() {
//            checkForComodification();
//            T result = curr.value;
//            curr = curr.next;
//            return result;
//        }
//
//        private void checkForComodification() {
//            if(expectedModCount != modCount) {
//                throw new ConcurrentModificationException();
//            }
//        }
//    }



    private static class Node<T> {
        private final T value;
        private Node<T> next = null;

        public Node(T value) {
            this.value = value;
        }
    }
}
