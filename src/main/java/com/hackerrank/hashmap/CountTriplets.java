package com.hackerrank.hashmap;

import java.util.*;

public class CountTriplets {
    static long min = 0;
    static long max = 0;

    static long countTriplets(List<Long> arr, long r) {
        arr = cleanArray(arr, r);
        //long min = Collections.min(arr);
        //long max = Collections.max(arr);

        //long i = min;
        //long j = i * r;
        //long k = i * r * r;

        long i, j, k;
        for (i = min; (j = i * r) <= max; i = (k = j * r)) {

        }


        long out = 0;

        return out;
    }

    static int nextIndex(Long n, int current, List<Long> arr) {
        int index = 0;
        for (int i = current + 1; i < arr.size(); i++) {
            if (arr.get(i).equals(n)) {
                index = i;
                break;
            }
        }
        return index;
    }

    static List<Long> cleanArray(List<Long> arr, long r) {
        List<Long> cleaned = new ArrayList<>();
        for (Long v : arr) {
            if (v == 1 || v % r == 0) {
                cleaned.add(v);
                if (min == 0 || min > v) min = v;
                if (max == 0 || max < v) max = v;
            }
        }
        return cleaned;
    }
    static Map<Long, Integer> countDuplicates(List<Long> arr) {
        Map<Long, Integer> cntArr = new HashMap<>();
        for (Long v : arr) {
            if (cntArr.keySet().contains(v))
                cntArr.put(v, cntArr.get(v) + 1);
            else
                cntArr.put(v, 1);
        }

        return cntArr;
    }

    /**
    static long countTriplets(List<Long> arr, long r) {
        arr = cleanArray(arr, r);
        //long min = Collections.min(arr);
        //long max = Collections.max(arr);

        long i = min;
        long j = i * r;
        long k = i * r * r;



        Map<Long, Integer> cntArrMap = countDuplicates(arr);
        long out = 0;
        if (cntArrMap.size() == 1) {
            long n = arr.size();
            for (long i = 1; i < n - 1; i++) {
                out += i * (n - i - 1);
            }

        } else {
            List<Long> keys = new ArrayList<>(cntArrMap.keySet());
            Collections.sort(keys);
            for(Long s : keys) {
                if (cntArrMap.keySet().contains(s * r)
                        && cntArrMap.keySet().contains(s * r * r)) {
                    out += cntArrMap.get(s) * cntArrMap.get(s * r)
                            * cntArrMap.get(s * r * r);
                }
            }
        }
        return out;
    }
     **/
}
