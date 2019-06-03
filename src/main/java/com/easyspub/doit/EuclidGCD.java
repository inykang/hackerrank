package com.easyspub.doit;

public class EuclidGCD {
    static long count = 0L;
    static int gcd(int x, int y) {
        System.out.println("count: " + ++count);
        if (y == 0)
            return x;
        else
            return gcd(y, x % y);
    }

}
