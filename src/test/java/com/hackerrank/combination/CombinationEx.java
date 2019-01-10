package com.hackerrank.combination;

public class CombinationEx {
    private static int[] result;
    private static int n;

    private static void printArray() {
        String str = "( ";
        for (int number : result) {
            str += number + " ";
        }
        System.out.print(str + ") ");
    }

    private static void gen(int index, int minI) {
        if (index == result.length) {
            printArray();
            return;
        }
        for (int i = minI; i <= n; i++) {
            result[index] = i;
            gen(index + 1, i);
        }
    }

    public static void main(String[] args) {
        int k = 3;

        result = new int[k];

        gen(3, 2);
    }
}
