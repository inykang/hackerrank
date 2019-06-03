package com.hackerrank.hashmap;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class CountTripletsTest {

    @Test
    public void countTriplets() throws IOException {
        //long ratio = 2L; String cs = "01"; //01, 2
        long ratio = 5L; String cs = "02";  //02, 4
        //long ratio = 1L; String cs = "03";  //03, 100, 161700
        //long ratio = 1L; String cs = "04";  //04, 100000, 166661666700000
        //long ratio = 3L; String cs = "05"; //05, 100000, 3, 2325652489
        //long ratio = 3L; String cs = "06"; //06, 6, 3, 6
        //long ratio = 100L; String cs = "07"; //07, 1000 100, 0
        //long ratio = 3L; String cs = "08"; // 08, 100000 3, 2325652489
        //long ratio = 100000L; String cs = "01"; //09, 100000 165427300, 0
        List<Long> arr = parseInputData("cnttrip-" + cs +".data");
        long out = CountTriplets.countTriplets(arr, ratio);
        System.out.println("output: " + out);
    }

    @Test
    public void testCountOneRatio() {
        int size = 100;
        long value = 1;
        List<Long> arr = Arrays.stream(new long[size])
                .boxed()
                //.toArray(Long[]::new)
                .map(v -> new Long(value))
                .collect(Collectors.toList());
        System.out.println(arr);

        int n  = arr.size();
        long count = 0;
        for (int i = 1; i <= n - 2; i++) {
            count += i * (n - i - 1);
        }
        System.out.println("count: " + count);
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
    public void testHashSet() {
        // Get the HashSet
        Set<Integer> set = new HashSet<Integer>();

        // fill the hashSet
        set.add(3);
        set.add(6);
        set.add(2);
        set.add(9);

        System.out.println(String.format(
                "min: %d, max: %d"
                , Collections.min(set)
                , Collections.max(set)
        ));

    }

    @Test
    public void testFindArr() {
        List<Long> arr =
                LongStream.of(1, 3, 9, 9, 27, 81)
                        .mapToObj(Long::new)
                        .collect(Collectors.toList());
        int iIdx = 0, jIdx, pos = 0;
        long min = 1;
        long max = 90;
        long i = min, j, k;
        long r = 3;
        long count = 0;
        int index = 0;
        arr = arr.stream().filter(n -> (n % r == 0)).collect(Collectors.toList());


        do {
            j = i * r;
            k = j * r;
            System.out.printf("\n[i:%d, j:%d, k:%d]\n", i, j, k);

            for (int ipos = index; ipos < arr.size(); ipos++) {
                int iidx = findIndex(arr, ipos, i);
                if (iidx < 0) break;
                for (int jpos = iidx + 1; jpos < arr.size(); jpos++) {
                    int jidx = findIndex(arr, jpos, j);
                    if (jidx < 0) break;
                    jpos = jidx;
                    count += countValue(arr, jidx + 1, k);
                }
                ipos = iidx;
            }
            System.out.println("count:" + count);

            index++;
            i = i * r;
        } while (k <= max);
    }

    private long countValue(List<Long> arr, int fromIndex, Long findValue) {
        long count = 0;
        for (int i = fromIndex; i < arr.size(); i++) {
            if (arr.get(i).equals(findValue))
                count++;
        }
        System.out.println(String.format(
                "from:%d, find:%d, count:%d"
                , fromIndex, findValue, count
        ));
        return count;
    }

    private int findIndex(List<Long> arr, int fromIndex, Long findValue) {
        int index = -1;
        for (int i = fromIndex; i < arr.size(); i++) {
            if (arr.get(i).equals(findValue)) {
                index = i;
                break;
            }
        }
        System.out.println(String.format(
                "from:%d, find:%d, index:%d"
                , fromIndex, findValue, index
        ));
        return index;
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