package com.hackerrank.array;

public class ArrayManipulation2 {
    private static long[] mainArray;
    private static long max = 0L;
    static long arrayManipulation(int n, int[][] queries) {
        if (mainArray == null)
            mainArray = new long[n];

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int add = queries[i][2];

            long[] tmpArray = new long[end - start + 1];
            System.arraycopy(
                    mainArray, start -1, tmpArray, 0, tmpArray.length
            );

            for (int j = 0; j < tmpArray.length; j++) {
                tmpArray[j] = tmpArray[j] + add;
                if (tmpArray[j] > max)
                    max = tmpArray[j];
            }

            System.arraycopy(
                    tmpArray, 0, mainArray, start - 1, tmpArray.length
            );
        }

        return max;
    }
}
