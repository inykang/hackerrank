package com.hackerrank.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class CountTriplets {
    private static List<Long> destination = new ArrayList<>();
    private static long min = 0;
    private static long max = 0;

    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long, Long> map1 = new HashMap<>();
        HashMap<Long, Long> map2 = new HashMap();
        long count = 0;
        for(int i = arr.size() - 1; i >= 0; i--) {
            long a = arr.get(i);
            if(map1.containsKey(a*r)) {
                long c = map1.get(a*r);
                map2.put(a, map2.getOrDefault(a, 0L) + c);
            }

            if(map2.containsKey(a*r))
                count += map2.get(a*r);

            map1.put(a, map1.getOrDefault(a, 0L) + 1);
        }
        return count;
    }

    static long countTriplets02(List<Long> arr, long r) {
        Map<Long, List<Integer>> indexMap = cleanAndIndexMap(arr, r);

        long count = 0;
        if (r == 1) {
            count = countOneRatio(indexMap);
            return count;
        }

        if (indexMap.isEmpty()) return count;

        long i = Collections.min(indexMap.keySet());
        long j = i * r;
        long k = j * r;
        long max = Collections.max(indexMap.keySet());

        while (k <= max) {
            System.out.printf("\n[i:%d, j:%d, k:%d]\n", i, j, k);

            List<Integer> indicesI = indexMap.get(i);
            List<Integer> indicesJ = indexMap.get(j);
            List<Integer> indicesK = indexMap.get(k);

            if (indicesI !=null && indicesJ !=null && indicesK !=null) {
                for (Integer indexI : indicesI) {
                    for (Integer indexJ : indicesJ) {
                        if (indexI < indexJ) {
                            for (Integer indexK : indicesK) {
                                if (indexJ < indexK) {
                                    count += indicesK.size() - indicesK.indexOf(indexK);
//                                    System.out.println(String.format(
//                                            "[%d,%d,%d] (%d,%d,%d), %d"
//                                            , i, j, k, indexI, indexJ, indexK, count
//                                    ));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("count: " + count);

            i = j;
            j = i * r;
            k = j * r;
        }

        return count;
    }

     static long countOneRatio(Map<Long, List<Integer>> indexMap) {
        long count = 0;
        for (Long key : indexMap.keySet()) {
            long n = indexMap.get(key).size();
            for (int i = 0; i < n - 1; i++) {
                count += i * (n - i - 1);
            }
        }
        return count;
    }


    static Map<Long, List<Integer>> cleanAndIndexMap(List<Long> arr, long r) {
        arr = arr.stream()
                .filter(n -> (n == 1) || ((n % r) == 0))
                .collect(Collectors.toList());

        Map<Long, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            Long n = arr.get(i);
            if (indexMap.keySet().contains(n)) {
                indexMap.get(n).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                indexMap.put(n, indices);
            }
        }
        return indexMap;
    }

    static long countTriplets01(List<Long> arr, long r) {
        for (Long n : arr) {
            if (n == 1 || n % r == 0) {
                destination.add(n);
                if (min == 0 || min > n) min = n;
                if (max < n) max = n;
            }
        }

        long i = min;
        long j = i * r;
        long k = j * r;
        int idx = 0;
        int length = destination.size();
        long count = 0;
        while (k <= max) {
            System.out.printf("\n[i:%d, j:%d, k:%d]\n", i, j, k);
            for (int ipos = idx; ipos < length; ipos++){
                int idxi = findIndex(ipos, i);
                if (idxi < 0) break;
                for (int jpos = idxi + 1; jpos < length; jpos++) {
                    int idxj = findIndex(jpos, j);
                    if (idxj < 0) break;
                    jpos = idxj;
                    count += countValues(idxj + 1, k);
                }
                ipos = idxi;
            }
            idx ++;

            i = i * r;
            j = i * r;
            k = j * r;
        }

        return count;
    }

    static long countValues(int fromIndex, long value) {
        long count = 0;
        for (int i = fromIndex; i < destination.size(); i++) {
            if (destination.get(i).equals(value)) {
                count ++;
            }
        }
        System.out.println(String.format(
                "from:%d, find:%d, count:%d"
                , fromIndex, value, count
        ));
        return count;
    }

    static int findIndex(int fromIndex, long findValue) {
        int index = -1;
        for (int i = fromIndex; i < destination.size(); i++) {
            if (destination.get(i).equals(findValue)) {
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
}
