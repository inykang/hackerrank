package com.hackerrank.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoCharactersTest {
    @Test
    public void alternate() {
        String s = "beabeefeab"; //5
        //String s = "asdcbsdcagfsdbgdfanfghbsfdab"; //8
        int answer = TwoCharacters.alternate(s);
        System.out.println(answer);
    }
}