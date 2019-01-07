package com.hackerrank.wpc;

public class CountingValleys {

    static int countingValleys(int n, String s) {
        int count = 0;
        long level = 0;
        boolean isEnter = false;

        char[] steps = s.toCharArray();
        for (int i = 0; i < steps.length - 1; i++) {
            if (steps[i] == 'D')
                level --;
            else if (steps[i] == 'U')
                level ++;

            if (!isEnter && level < 0) {
                count++;
                isEnter = true;
            } else if (isEnter && level == 0)
                isEnter = false;
        }

        System.out.printf("\ncount: %d, level: %d", count, level);
        return count;
    }


}
