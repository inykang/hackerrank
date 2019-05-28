package com.hackerrank.array;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class ArrayManipulation {
    private static long[] mainArr;
    private static long max = 0L;

    static long arrayManipulation(int n, int[][] queries) {
        long[] gapBehindArr = new long[n];

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0] - 1;
            int b = queries[i][1] - 1;
            int k = queries[i][2];

            gapBehindArr[a] += k;
            if (b + 1 < n ) {
                gapBehindArr[b + 1] -= k;
            }
        }

        long max = 0; long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gapBehindArr[i];
            max = Math.max(max, sum);
        }

        return max;
    }

    static long arrayManipulation03(int n, int[][] queries) throws InterruptedException {
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

    static long arrayManipulation01(int n, int[][] queries) {
        if (mainArr == null)
            mainArr = new long[n];

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int add = queries[i][2];

            long[] tmpArr = new long[end - start + 1];
            System.arraycopy(
                    mainArr, start -1, tmpArr, 0, tmpArr.length
            );

            for (int j = 0; j < tmpArr.length; j++) {
                tmpArr[j] = tmpArr[j] + add;
                if (tmpArr[j] > max)
                    max = tmpArr[j];
            }

            System.arraycopy(
                    tmpArr, 0, mainArr, start - 1, tmpArr.length
            );
        }

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
