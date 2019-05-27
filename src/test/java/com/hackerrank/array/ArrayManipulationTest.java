package com.hackerrank.array;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ArrayManipulationTest {

    @Test
    public void arrayManipulation() throws IOException {
        int n = 10000000;
        int m = 100000;
        //int n = 5;
        //int m = 3;

        int[][] queries = new int[m][3];
        queries = parseInputData(queries, "arrmanip-02.data");
//        for (int i = 0; i < queries.length; i++) {
//            System.out.println(Arrays.toString(queries[i]));
//        }
        System.out.println(ArrayManipulation.arrayManipulation(n, queries));
    }
    @Test
    public void testConcurrent() {
        int n = 10;
        int r = IntStream.range(0, n).parallel().map(i -> i + 1).sum();
        System.out.println(r);
    }

    @Test
    public void testRunnable() {
        final List<Integer> integers =  Arrays.asList(1,2,3,4,5);

        Callable<Integer> callableObj = () -> {
            int result = integers.stream().mapToInt(i -> i.intValue()).sum();
            return result;
        };
        ExecutorService service =  Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(callableObj);
        Integer result=0;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Sum = "+result);

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