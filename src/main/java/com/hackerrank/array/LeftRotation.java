package com.hackerrank.array;

public class LeftRotation {

    static int[] rotLeft(int[] a, int d) {
        int len = a.length;
        int[] rst = new int[len];
        System.arraycopy(a, d, rst, 0, len - d);
        System.arraycopy(a, 0, rst, len - d, d);
        return rst;
    }
}
