package com.exam.se06.sets;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    @Test
    void name() {
        Set<Object> set = new HashSet<>();
        set.add(set);
        System.out.println(set.contains(set));
    }
}
