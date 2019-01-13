package org.greeksforgreeks.permutation;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapPermutationTest {

    @Test
    public void heapPermutation() {
        HeapPermutation perm = new HeapPermutation();
        int a[] = {1,2,3,4,5,6,7,8};
        int r = 5;
        perm.heapPermutation(a, a.length, r);
    }
}