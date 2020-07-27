package com.exam.se06.sets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
//    @Test(expected = StackOverflowError.class) //JUnit4
    @Test
    void hashMapQuiz() {
        Set<Object> set = new HashSet<>();
        set.add(set);
        Assertions.assertThrows(StackOverflowError.class, () -> set.contains(set));
    }
}
