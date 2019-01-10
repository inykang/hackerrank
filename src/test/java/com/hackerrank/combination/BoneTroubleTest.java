package com.hackerrank.combination;

import org.junit.Test;

import java.util.Arrays;

public class BoneTroubleTest {

    @Test
    public void bonetrousle() {
        long n = 2, k = 3;
        int b = 1;

        long[] results = BoneTrouble.bonetrousle(n, k, b);
        System.out.println(Arrays.toString(results));
    }
}