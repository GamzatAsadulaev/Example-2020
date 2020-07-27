package com.exam.se06.collections;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
public class CollectionTest {
    @Test
    void name() {
        List<Integer> source = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> result = source.stream()
                .filter(value -> value > 3)
                .collect(Collectors.toList());
        assertThat(source, Matchers.contains(1, 2, 3, 4, 5));
        assertThat(result, Matchers.contains(4, 5));

        source.removeIf(value -> value < 4);
        assertThat(source, Matchers.contains(4, 5));

        source.forEach(System.out::println);

    }


}
