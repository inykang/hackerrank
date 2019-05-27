package com.hackerrank.array;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ArrayManipulation {
    static long arrayManipulation(int n, int[][] queries) {
        return
        LongStream.range(0, n -1).parallel()
                .map(index -> {
                    long sum = 0L;
                    for (int row = 0; row < queries.length; row++) {
                        int start = queries[row][0];
                        int end = queries[row][1];
                        int value = queries[row][2];
                        if (index >= start && index <= end)
                            sum = sum + value;
                    }
                    System.out.println(sum);
                    return sum;
                }).max().getAsLong();
    }
}
