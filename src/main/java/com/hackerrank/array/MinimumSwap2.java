package com.hackerrank.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwap2 {
    static int minimumSwaps(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        Arrays.sort(arr);
        int[] idxs = new int[n];
        for (int i = 0; i < n; i++) {
            idxs[i] = map.get(arr[i]);
        }

        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int v = idxs[i];
            if (v < 0) continue;
            while (v != i) {
                int nv = idxs[v];
                idxs[v] = -1;
                v = nv;
                swaps ++;
            }
        }
        return swaps;
    }
    static int minimumSwaps4(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }
        map = null;
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            if (val < 0) continue;
            while (val != i) {
                int new_val = arr[val];
                arr[val] = -1;
                val = new_val;
                swaps++;
            }
            arr[i] = -1;
        }
        return swaps;
    }
    static int minimumSwaps3(int[] arr) {
        int fixed = 0;
        int pairs = 0;

        for (int i = 0; i < arr.length; i++) {
            int move = i + 1 - arr[i];

            //count data not to swap
            if (move == 0) fixed = fixed + 1;
            //count data to swap in pairs
            else if ((move < 0) && ((i + 1) == arr[i - move])) {
                pairs = pairs + 1;
                System.out.println(String.format(
                        "pairs: i: %d, v: %d, move: %d, p: %d",
                        i + 1, arr[i], move, arr[i - move]
                ));
            }
        }

        // count remains
        int remains = arr.length - fixed - 2 * pairs;
        if ( remains > 0) remains = remains -1;

        System.out.println(String.format(
                "arr:%s\nfixed: %d, pairs: %d, remains: %d",
                Arrays.toString(arr),
                fixed, pairs, remains
        ));

        return remains + pairs;
    }

    static int minimumSwaps2(int[] arr) {
        //filter candidates to be swapped
        Map<Integer, Integer> backward = new HashMap<>();
        Map<Integer, Integer> forward = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int move = i + 1 - arr[i];
            if (move > 0)
                forward.put(arr[i], move);
            else if (move < 0)
                backward.put(arr[i], move);
        }

        //count swap in pairs
        int pairs = 0;
        for (Integer bk : backward.keySet()) {
            for (Integer fk : forward.keySet()) {
                if (backward.get(bk) * (-1) == forward.get(fk)) {
                    pairs = pairs + 1;
                    continue;
                }
            }
        }
        //count swap others
        int swapCount = forward.size() + backward.size() - (2 * pairs);
        if (swapCount > 0) swapCount = swapCount - 1;

        System.out.println(String.format(
                "forward(%d):%s\nbackeward(%d):%s\neach: %d, swap: %d"
                , forward.size(), forward, backward.size(), backward,
                pairs, swapCount
        ));

        return swapCount + pairs;
    }
}
