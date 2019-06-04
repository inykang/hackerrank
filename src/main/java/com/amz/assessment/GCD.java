package com.amz.assessment;

class GCD
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr)
    {
        // WRITE YOUR CODE HERE
        int result = arr[0];
        for (int i = 1; i < num; i++) {
            result = gcd(arr[i], result);
        }
        return result;
    }
    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    // METHOD SIGNATURE ENDS
}
