package com.hackerrank.string;

public class SuperReducedString {
    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        char[] arr = s.toCharArray();
        boolean done = false;
        while (!done) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    if (arr.length == 2) {
                        return "Empty String";
                    }
                    arr = removeCharacters(arr, i);
                    if (arr.length == 1) {
                        done = true;
                    }
                    break;
                }
                if (i == arr.length - 2) {
                    done = true;
                }
            }
        }
        return new String(arr);
    }

    static char[] removeCharacters(char[] arr, int index) {
        char[] tmp = new char[arr.length - 2];
        int arrIdx = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (i == index) arrIdx += 2;
            tmp[i] = arr[arrIdx];
            arrIdx++;
        }
        return tmp;
    }
}