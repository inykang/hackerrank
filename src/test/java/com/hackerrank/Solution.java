package com.hackerrank;

import java.io.InputStream;
import java.util.Scanner;

public class Solution {
    private static boolean flag;
    private static int B;
    private static int H;

    static {
        InputStream is = ClassLoader.getSystemResourceAsStream("data/initblock.data");
        Scanner sc = new Scanner(is);
        B = sc.nextInt();
        H = sc.nextInt();
        sc.close();

        if (B > 0 && H > 0)
            flag = true;
        else
            System.out.println("java.lang.Exception: Breadth and height must be positive");
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.println(area);
        }
    }
}
