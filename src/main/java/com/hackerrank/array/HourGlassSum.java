package com.hackerrank.array;

public class HourGlassSum {
    static int hourglassSum(int[][] arr) {
        int max = 0;
        for (int r = 0; r < arr.length - 2; r++) {
            for (int c = 0; c < arr.length - 2; c++) {
                int sum = arr[r][c+0] + arr[r][c+1] + arr[r][c+2]
                        + arr[r+1][c+1]
                        + arr[r+2][c+0] + arr[r+2][c+1] + arr[r+2][c+2];

                System.out.print(sum + ", ");

                if (r == 0 && c == 0)
                    max = sum;
                if ( sum > max)
                    max = sum;
            }
        }

        return max;
    }
}
