package com.codehouse.junit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JUnitFixMethodOrderTest {
    @Test
    public void firstTest() {
        System.out.println("First Test");
    }

    @Test
    public void secondTest() {
        System.out.println("Second Test");
    }

    @Test
    public void thirdTest() {
        System.out.println("Third Test");
    }
}
