package com.baeldung.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {
    @Test
    public void arithmeticOperations() {
        int[] ints = new int[]{20, 98, 12, 7, 35};
        int min = Arrays.stream(ints)
                .min()
                .getAsInt();

        System.out.println(Arrays.toString(ints));
        System.out.println("min: " + min);
    }

    @Test
    public void arithmeticOperations2() {
        int sum = IntStream.of(20, 98, 12, 7, 35)
                .sum();

        double avg = IntStream.of(20, 98, 12, 7, 35)
                .average()
                .getAsDouble();

        System.out.printf("\nsum:%d, avg:%f", sum, avg);
    }

    @Test
    public void range() {
        IntStream.range(1, 5).forEach(i -> System.out.print(i + ", "));
        System.out.println();
        IntStream.rangeClosed(1, 5).forEach(i -> System.out.print(i + ", "));

    }

    @Test
    public void boxing() {
        IntStream.rangeClosed(1, 10)
                .filter(i -> i % 2 == 0)
                .boxed()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void streamGenerate() {
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
        streamGenerated.forEach(System.out::println);
    }

    @Test
    public void streamIterate() {
        Stream<Integer> streamIteratec = Stream.iterate(40, n -> n + 1).limit(10);
        streamIteratec.forEach(System.out::println);
    }
}
