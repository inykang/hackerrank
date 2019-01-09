package com.hackerrank.wpc;

import org.junit.Test;

import static org.junit.Assert.*;

public class RepeatedStringTest {
    @Test
    public void repeatedString() {
        assertEquals(RepeatedString.repeatedString("aba", 10L), 7);
        assertEquals(RepeatedString.repeatedString("a", 1000000000000L), 1000000000000L);
    }

}