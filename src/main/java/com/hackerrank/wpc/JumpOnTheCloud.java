package com.hackerrank.wpc;

public class JumpOnTheCloud {
    static int jumpingOnClouds(int[] c) {
        int steps = 0;
        int accum = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 1) {
                steps++;
                steps = steps + (accum / 2);
                accum = 0;
            } else {
                accum++;
            }
        }

        if (accum > 0)
            steps = steps + (accum / 2);
        return steps;
    }
}
