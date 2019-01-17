package com.baeldung.stream;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

public class StreamEx {
    @Test
    public void arithmeticOperations() {
        int[] ints = new int[] {20, 98, 12, 7, 35};
        int min = Arrays.stream(ints)
                .min()
                .getAsInt()
                ;

        System.out.println(Arrays.toString(ints));
        System.out.println("min: " + min);
    }

    @Test
    public void arithmeticOperations2() {
        int sum = IntStream.of(20, 98, 12, 7, 35)
                .sum();

        double avg = IntStream.of(20, 98, 12, 7, 35)
                .average()
                .getAsDouble()
                ;

        System.out.printf("\nsum:%d, avg:%f", sum, avg);
    }

    @Test
    public void range() {
        IntStream.range(1,5).forEach(i -> System.out.print(i + ", "));
        System.out.println();
        IntStream.rangeClosed(1,5).forEach(i -> System.out.print(i + ", "));

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

    @Test
    public void collectToMap() {
        List<String> list = Arrays.asList("a", "bb", "ccc", "dd", "a");
        List<String> linked = list.stream()
                .collect(toCollection(LinkedList::new));
        list.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length,
                        (i1, i2) -> i1 + i2)
                )
                .forEach((k, v) -> System.out.println("k = " + k + ", v = " + v))
        ;
    }

    @Test
    public void collectingAndThen() {
        Stream.of("a", "bb", "ccc", "dd", "a")
                .collect(Collectors.collectingAndThen(toList(), ImmutableList::copyOf))
                .forEach(System.out::println)
        ;
    }

    @Test
    public void collectSummerizing() {
        DoubleSummaryStatistics stat =
                Stream.of("a", "bb", "ccc", "dd")
                        .collect(Collectors.summarizingDouble(String::length));
        System.out.println(String.format(
                "average: %f, count: %d, max: %f, min: %f, sum: %f",
                stat.getAverage(), stat.getCount(), stat.getMax(), stat.getMin(),
                stat.getSum()
        ));
    }

    @Test
    public void collectGroupingBy() {
        Stream.of("a", "bb", "ccc", "dd")
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()))
                .forEach((c, s) -> System.out.println(c + " : " + s))
        ;
    }

    @Test
    public void concurrentGrouping() {
        Stream.of("a", "bb", "ccc", "dd", "bb", "dd")
                .collect(Collectors.groupingByConcurrent(
                        Function.identity(), Collectors.counting()
                ))
                .forEach((k,v) -> System.out.println("k: " + k + ", v: " + v))
        ;
    }
}
