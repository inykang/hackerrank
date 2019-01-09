package com.hackerrank.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LeftRotationTest {

    @Test
    public void rotLeft() {
        String in = "1 2 3 4 5";
        int d = 2;

        int[] rst = LeftRotation.rotLeft(parseInData(in), d);
        System.out.println(Arrays.toString(rst));
    }

    private int[] parseInData(String s) {
        String[] strs = s.split(" ");
        int[] ints = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            ints[i] = Integer.parseInt(strs[i]);
        }
        return ints;
    }
}