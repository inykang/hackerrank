package com.hackerrank.wpc;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountingValleysTest {

    @Test
    public void countingValleys() {
        int steps = 8;
        String traces = "DUDDDUUDUU";

        CountingValleys.countingValleys(steps, traces);
    }
}