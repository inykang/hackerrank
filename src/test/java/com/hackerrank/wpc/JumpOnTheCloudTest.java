package com.hackerrank.wpc;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpOnTheCloudTest {

    @Test
    public void jumpingOnClouds() {
        int[] c = {0, 0, 1, 0, 0, 1, 0};
        int steps = JumpOnTheCloud.jumpingOnClouds(c);
        System.out.println("steps: " + steps);

        int[] c2 = {0, 0, 0, 0, 1, 0};
        System.out.println("steps: " + JumpOnTheCloud.jumpingOnClouds(c2));

        int[] c3 = {0, 0, 1, 0, 0, 1, 0};
        System.out.println("steps: " + JumpOnTheCloud.jumpingOnClouds(c3));

        int[] c4 = {0, 0, 0, 1, 0, 0};
        System.out.println("steps: " + JumpOnTheCloud.jumpingOnClouds(c4));

    }
}