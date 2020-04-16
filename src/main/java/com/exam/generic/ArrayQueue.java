package com.exam.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E>{
    private static final int DEFAULT_CAPACITY = 16;
    private Object[] data = new Object[DEFAULT_CAPACITY];
    private int indexPut = 0;
    private int indexPoll = 0;

    @Override
    public void put(E value) {
        if(indexPut == data.length) {
//            Object[] tmp = new Object[data.length * 2];
//            for(int i = 0; i < data.length; i++) {
//                tmp[i] = data[i];
//            }
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[indexPut++] = value;
    }

    @Override
    //@SuppressWarnings("unchecked")
    public E poll() {
        checkNotEmpty();
        Object result = data[indexPoll++];
        if(indexPoll == data.length / 2) {
            Object[] tmp = new Object[data.length / 2];
            System.arraycopy(data, indexPoll, tmp, 0, tmp.length);
            indexPoll = 0;
            indexPut -= tmp.length;
            data = tmp;
        }
        return (E) result;
    }

    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() throws NoSuchElementException{
        checkNotEmpty();
        return (E) data[indexPoll];
    }

    @Override
    public boolean isEmpty() {
        return indexPut == indexPoll;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
