package com.hackerrank.combination;

import org.junit.Test;

public class CombinationRepetition {
    private static int depth = 0;
    static void CombinationRepetitionUtil(int chosen[], int arr[],
                                          int index, int r, int start, int end) {
        // Since index has become r, cu3.3rrent combination is
        // ready to be printed, print
        if (index == r) {
            for (int i = 0; i < r; i++) {
                System.out.printf("%d ", arr[chosen[i]]);
            }
            System.out.printf("\n");
            return;
        }

        System.out.println(String.format(
                "depth: %d, index: %d, r: %d, start: %d, end: %d",
                depth, index, r, start, end
        ));
        depth ++;

        // One by one choose all elements (without considering
        // the fact whether element is already chosen or not)
        // and recur
        for (int i = start; i <= end; i++) {
            chosen[index] = i;
            CombinationRepetitionUtil(chosen, arr, index + 1,r, i, end);
        }
        return;
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n with repitions. This function mainly
    // uses CombinationRepetitionUtil()
    static void CombinationRepetition(int arr[], int n, int r) {
        // Allocate memory
        int chosen[] = new int[r + 1];

        // Call the recursice function
        CombinationRepetitionUtil(chosen, arr, 0, r, 0, n - 1);
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        int r = 3;
        CombinationRepetition(arr, n, r);
    }

}
