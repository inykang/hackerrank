package com.hackerrank.combination;

import org.junit.Test;

public class WorkScheduleTest {

    @Test
    public void findSchedule() {
        int workHours = 56, dayHours = 8;
        String pattern = "???8???";
        WorkSchedule.findSchedule(workHours, dayHours, pattern);

    }

    @Test
    public void print() {
        int c = 8;
        String pattern = "???8???";
        char[] chars = pattern.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                chars[i] = (char) (c+'0');
            }
        }

        System.out.println(new String(chars));

    }


    @Test
    public void createLexicographicalArray() {
        int size = 3;
        int[] ints = new int[size];
        for (int i = 0; i < ints.length; i++) {
            for (int c = 0; c < ints.length; c++) {
                for (int r = 0; r < ints.length; r++) {

                }
            }


        }
    }

}