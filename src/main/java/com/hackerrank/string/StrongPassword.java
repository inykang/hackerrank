package com.hackerrank.string;

import java.util.Arrays;
import java.util.List;

public class StrongPassword {
    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int adding = 0;
        int more = 0;

        if (n < 6) more = 6 - n;

        char[] arr = password.toCharArray();
        int[] constraints = countConstraint(arr);
        for (int i = 0; i < constraints.length; i ++) {
            if (constraints[i] == 0) {
                adding ++;
            }
        }

        return Math.max(adding, more);
    }

    static int[] countConstraint(char[] arr) {
        List<Integer> specials = Arrays.asList(33, 64, 35, 36, 37, 94, 38, 42, 40, 41, 45, 43);
        int[] counts = {0, 0, 0, 0}; // digit, lowcase, uppercase, special
        for (int i = 0; i < arr.length; i ++) {
            int ascii = arr[i];
            //digit
            if (ascii >= 48 && ascii <= 57) {
                counts[0] += 1;
                //lowcase
            } else if (ascii >= 97 && ascii <= 122) {
                counts[1] += 1;
                //uppercase
            } else if (ascii >= 65 && ascii <= 90) {
                counts[2] += 1;
                //special
            } else if (specials.contains(ascii)) {
                counts[3] += 1;
            }
        }
        return counts;
    }
}
