package com.easyspub.doit;

import org.junit.Test;

import static org.junit.Assert.*;

public class EuclidGCDTest {

    @Test
    public void testGCD01() {
        int x = 50, y = 15;
        //int x = 15, y = 50;
        int z = EuclidGCD.gcd(x, y);
        System.out.println(z);
    }

}