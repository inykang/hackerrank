package com.hackerrank.array;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ArrayManipulationTest {

    @Test
    public void arrayManipulation() throws IOException, InterruptedException {
        long s = System.currentTimeMillis();
        int n = 10000000, m = 100000; // 02
        //int n = 5, m = 3; // 01
        //int n = 4, m = 3;  // 03, 882
        //int n = 10, m = 3;  // 04, 10

        int[][] queries = new int[m][3];
        queries = parseInputData(queries, "arrmanip-02.data");
//        for (int i = 0; i < queries.length; i++) {
//            System.out.println(Arrays.toString(queries[i]));
//        }
        System.out.println(ArrayManipulation.arrayManipulation(n, queries));
        System.out.println("elapsed: " + (System.currentTimeMillis() -s));
    }

    @Test
    public void testConcurrent() {
        int n = 10;
        int r = IntStream.range(0, n).parallel().map(i -> i + 1).sum();
        System.out.println(r);
    }

    @Test
    public void testFutureTask() throws IOException {
        int n = 4, m = 3;  // 03, 882

        int[][] queries = new int[m][3];
        queries = parseInputData(queries, "arrmanip-03.data");
        for (int i = 0; i < queries.length; i++) {
            System.out.println(Arrays.toString(queries[i]));
        }

        ExecutorService service = Executors.newFixedThreadPool(n);
        List<FutureTask<Long>> taskList = new ArrayList<>();
//        FutureTask<Long> t1 = new FutureTask<>(new Callable<Long>() {
//            @Override
//            public Long call() {
//
//            }
//        })

    }

    @Test
    public void testExecute() throws IOException, InterruptedException {
        //int n = 10000000, m = 100000; // 02
        //int n = 5, m = 3; // 01
        int n = 4, m = 3;  // 03, 882

        int[][] queries = new int[m][3];
        queries = parseInputData(queries, "arrmanip-03.data");
        for (int i = 0; i < queries.length; i++) {
            System.out.println(Arrays.toString(queries[i]));
        }
        //System.out.println(ArrayManipulation.arrayManipulation(n, queries));

        //ExecutorService service = Executors.newFixedThreadPool(n);
        ExecutorService service = Executors.newWorkStealingPool();
        List<Callable<Long>> callables = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            callables.add(callable(i, queries));
        }

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
        ;
    }

    Callable<Long> callable(int idx, int[][] queries) {
        System.out.println("index:" + idx);
        return () -> {
            Long sum = 0L;
            for (int i = 0; i < queries.length; i++) {
                if (idx >= queries[i][0] && idx <= queries[i][1])
                    sum = sum + queries[i][2];
            }
            System.out.println("sum:" + sum);
            return sum;
        };
    }

/*    Callable<Long> callable(int idx, int[][] queries) {
        return() -> {
            Long sum = 0L;
            for (int i = 1; i <= queries.length; i++) {
                if (idx >= queries[i][0] && idx <= queries[i][1])
                    sum = sum + queries[i][2];
            }
            return sum;
        };
    }*/

    @Test
    public void testRunnable() {
        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        Callable<Integer> callableObj = () -> {
            int result = integers.stream().mapToInt(i -> i.intValue()).sum();
            return result;
        };
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(callableObj);
        Integer result = 0;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Sum = " + result);

    }

    @Test
    public void doubleArrayTest() {
        int[][] arr = new int[2][3];
        System.out.println(arr.length);
    }

    @Test
    public void testInitArray() {
        int[] results = new int[100];
        System.out.println(Arrays.toString(results));
    }

    private int[][] parseInputData(int[][] queries, String fileName) throws IOException {
        InputStream is = ClassLoader.getSystemResourceAsStream("array/" + fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        int row = 0;
        while ((line = reader.readLine()) != null) {
            String[] strs = line.split(" ");
            for (int col = 0; col < strs.length; col++) {
                queries[row][col] = Integer.parseInt(strs[col]);
            }
            row++;
        }

        return queries;
    }
}