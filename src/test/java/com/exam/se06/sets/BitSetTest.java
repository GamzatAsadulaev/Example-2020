package com.exam.se06.sets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

public class BitSetTest {
    @Test
    void name() {
        long mask1 = 0b010100001010;
        long mask2 = 0b010101001110;
        assertEquals(0b010100001010, mask1 & mask2);

        BitSet bitSet1 = new BitSet();

        bitSet1.set(0);
        bitSet1.set(10);
        bitSet1.set(123);
        assertFalse(bitSet1.get(124));
        assertTrue(bitSet1.get(123));

        BitSet bitSet2 = new BitSet();
        bitSet2.set(10);

        bitSet1.and(bitSet2);
        assertTrue(bitSet1.get(10));

        bitSet1.clear(10);
        assertTrue(bitSet1.isEmpty());

    }
}
