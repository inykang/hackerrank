package com.hackerrank.array;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ArrayManipulation {
    static long arrayManipulation(int n, int[][] queries) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(n);

        List<Callable<Long>> callables = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            callables.add(callable(i, queries));
        }

        long max =
        service.invokeAll(callables)
                .stream()
                .map(f -> {
                    try {
                        return f.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .max(Long::compare)
                .get()
        ;


        return max;
    }

    static Callable<Long> callable(int idx, int[][] queries) {
        return () -> {
            Long sum = 0L;
            for (int i = 0; i < queries.length; i++) {
                if (idx >= queries[i][0] && idx <= queries[i][1])
                    sum = sum + queries[i][2];
            }
            return sum;
        };
    }

    static long sum(int index, int[][] queries) {
        long sum = 0L;
        for (int i = 1; i <= queries.length; i++) {
            if (index >= queries[i][0] && index <= queries[i][1])
                sum = sum + queries[i][2];
        }
        return sum;
    }

    static long arrayManipulation02(int n, int[][] queries) {
        return
        LongStream.range(1, n + 1 ).parallel()
                .map(index -> {
                    long sum = 0L;
                    for (int row = 0; row < queries.length; row++) {
                        int start = queries[row][0];
                        int end = queries[row][1];
                        int value = queries[row][2];
                        System.out.println(String.format(
                                "index:%d, row:%d, start:%d, end:%d, value:%d"
                                , index, row, start, end, value
                        ));
                        if (index >= start && index <= end) {
                             sum = sum + value;
                        }
                    }
                    System.out.println(sum);
                    return sum;
                }).max().getAsLong();
    }
}
