package com.hackerrank.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class SuperReducedStringTest {
    @Test
    public void testSuperReducedString() {
        //String s = "aaabccddd"; //abd
        String s = "aabbccddd"; //abd
        String ans = SuperReducedString.superReducedString(s);
        System.out.println(ans);
    }
}