package com.hackerrank.string;

import org.junit.Test;

public class StrongPasswordTest {
    @Test
    public void minimumNumber() {
        String s = "4700"; //3
        //String s = "goxg"; //3
        //String s = "IGEC"; //3
        int answer = StrongPassword.minimumNumber(s.length(), s);
        System.out.println(answer);
    }

}