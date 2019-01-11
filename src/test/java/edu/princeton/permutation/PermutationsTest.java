package edu.princeton.permutation;

import org.junit.Test;

import static org.junit.Assert.*;

public class PermutationsTest {

    @Test
    public void permute() {
        int n = 3;
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);
        Permutations.perm1(elements);
        System.out.println();
        Permutations.perm2(elements);
    }

    @Test
    public void permote2() {
        char[] arr = {'A', 'B', 'C'};
        Permutations.perm2(arr, 3);
    }

}