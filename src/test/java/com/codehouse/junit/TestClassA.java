package com.codehouse.junit;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestClassA {
    @Test
    public void test_A_1(){
        assertTrue(1==2);
    }
    @Test
    public void test_A_2(){
        assertTrue(true);
    }
}
