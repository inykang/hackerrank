package com.hackerrank.combination;

import org.junit.Test;

import org.apache.commons.math3.util.Combinations;

import java.util.Arrays;

public class CombinationWithDuplicationEx {
    @Test
    public void createCombinationArray() {
        int[] arr = {0, 1, 2, 3, 4, 5};
        int n = arr.length;
        int r = 3;

        int[] comb = new int[r + 1];

        for (int idx = 0; idx < r + 1; idx++) {
            for (int i = 0; i < n - 1; i++) {
                comb[idx] = i;
            }

        }
    }

    @Test
    public void combination() {
        Combinations comb = new Combinations(6, 3);
        comb.iterator().forEachRemaining(
                ints -> System.out.println(Arrays.toString(ints))
        );

    }
}
