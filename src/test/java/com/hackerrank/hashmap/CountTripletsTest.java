package com.hackerrank.hashmap;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class CountTripletsTest {

    @Test
    public void countTriplets() throws IOException {
        //long ratio = 2L;  //01, 2
        //long ratio = 5L;  //02, 4
        //long ratio = 1L;  //03, 100, 161700
        //long ratio = 1L;  //04, 100000, 166661666700000
        long ratio = 3L; //05, 100000, 3, 2325652489
        List<Long> arr = parseInputData("cnttrip-05.data");
        long out = CountTriplets.countTriplets(arr, ratio);
        System.out.println("output: " + out);
    }

    @Test
    public void test() {
        long min = 1;
        long max = 90;
        long r = 3;

        for (long i = min; (i * r * r) <= max; i = i * r) {
            System.out.println(String.format(
                    "i: %d, j: %d, k: %d"
                    , i, i * r, i * r * r
            ));
        }

    }

    @Test
    public void testList() {
        List<Long> arr =
                LongStream.of(1, 3, 3, 9, 3, 27)
                        .mapToObj(Long::new)
                        .collect(Collectors.toList());
        long min = 1, max = 90, r = 3;
        int current = -1;
        int index;
        for (long i = min; i <= max; i = i * r) {

            while ((index = nextIndex(i, current, arr)) >= 0) {
                current = index;
                System.out.println(i + ", " + current);
            }
        }

    }

    @Test
    public void testLoop() {
        long min = 1, max = 90, r = 3;
        long i, j, k;
        for (i = min; (j = i * r) * r <= max; i = j) {
            k = j * r;
            System.out.println(String.format(
                    "[%d, %d, %d]"
                    , i, j, k
            ));
        }
    }

    @Test
    public void testFindArr() {
        List<Long> arr =
                LongStream.of(1, 3, 3, 9, 3, 27)
                        .mapToObj(Long::new)
                        .collect(Collectors.toList());
        int index = 0;
        long min = 1;
        long max = 90;
        long i = min, j, k;
        long r = 3;

        do {
            j = i * r;
            k = j * r;

        } while (k < max);
    }

    private int nextIndex(Long n, int current, List<Long> arr) {
        int index = -1;
        for (int i = current + 1; i < arr.size(); i++) {
            if (arr.get(i).equals(n)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Test
    public void testPower() {
        int n = 100000;
        long sum = 0;
        for (long i = 1; i < n - 1; i++) {
            sum += i * (n - i - 1);
        }
        System.out.println(sum);
    }

    @Test
    public void test01() {
        int n = 100000;
        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            System.out.println(String.format(
                    "n:%d, i:%d, v:%d",
                    n, i, i * (n - i - 1)
            ));
        }
    }


    @Test
    public void testMath() {
        long s = 1, r = 2;
        System.out.println(s * r * r);
    }

    @Test
    public void testHashMap() {
        Map<Long, Integer> map = new HashMap<>();
        map.put(1L, 1);
        map.put(2L, 2);
        map.put(4L, 1);

        for (Long v : map.keySet())
            System.out.println(v);

        System.out.println(map.size());


    }

    private List<Long> parseInputData(String fileName) throws IOException {
        InputStream is = ClassLoader.getSystemResourceAsStream("hashmap/" + fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        List<Long> arr = new ArrayList<>();
        for (String s : reader.readLine().split(" "))
            arr.add(Long.valueOf(s));

        return arr;
    }

}