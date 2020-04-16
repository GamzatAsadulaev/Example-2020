package com.exam.generic;

import java.util.NoSuchElementException;
// First
// In
// First
// Out
public interface Queue <E> extends Iterable<E> {
    public void put(E value);

    E poll();

    /**
     *
     * @return element from head (without delete)
     * @throws NoSuchElementException When empty
     */
    E peek() throws NoSuchElementException;
    boolean isEmpty();

}
