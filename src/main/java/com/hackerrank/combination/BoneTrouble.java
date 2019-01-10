package com.hackerrank.combination;

public class BoneTrouble {
    private static int k;
    private static long[] c;
    private static boolean more = true;
    private static int j;

    /*
     * Complete the bonetrousle function below.
     */
    static long[] bonetrousle(long n, long k, int b) {
        long[] results = null;
        /*
         * Write your code here.
         */
        if(!isValidRange(n, k, b)) {
            results = new long[1];
            results[0] = -1L;
        }

        initialize(k, b);
        while (more) {
            long[] rstArr = next(1L);
            if (n == sum(rstArr)) {
                results = rstArr;
                break;
            }
        }

        return results;

    }

    private static boolean isValidRange(long n, long k, int b) {
        if (sum(1, k) < n || sum(k - b, k) < n)
            return false;
        else
            return true;
    }

    private static long sum(long[] arr) {
        long sum = 0L;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    private static long sum(long s, long e) {
        if (s > e) {
            System.out.println(String.format(
                    "start number should be bigger than end number! s:%d, e:%d"
                    , s, e
            ));
        }
        return ((s + e) * (e - s + 1) / 2);
    }

    private static void initialize(long limit, int b) {
        k = b;
        c = new long[b + 3];
        if (b == 0 || b >= limit) {
            more = false;
            return;
        }
        // Initialize c to start with lexicographically first k-set
        for (int i = 1; i <= b; i++) {
            c[i] = i - 1;
        }
        // Initialize sentinels
        c[b + 1] = limit;
        c[b + 2] = 0;
        j = b;

    }

    public static long[] next(long startNum) {
        long[] arr = next();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + startNum;
        }
        return arr;
    }

    public static long[] next() {
        // Copy return value (prepared by last activation)
        final long[] ret = new long[k];
        System.arraycopy(c, 1, ret, 0, k);

        // Prepare next iteration
        // T2 and T6 loop
        long x = 0L;
        if (j > 0) {
            x = j;
            c[j] = x;
            j--;
            return ret;
        }
        // T3
        if (c[1] + 1 < c[2]) {
            c[1]++;
            return ret;
        } else {
            j = 2;
        }
        // T4
        boolean stepDone = false;
        while (!stepDone) {
            c[j - 1] = j - 2;
            x = c[j] + 1;
            if (x == c[j + 1]) {
                j++;
            } else {
                stepDone = true;
            }
        }
        // T5
        if (j > k) {
            more = false;
            return ret;
        }
        // T6
        c[j] = x;
        j--;
        return ret;
    }
}
