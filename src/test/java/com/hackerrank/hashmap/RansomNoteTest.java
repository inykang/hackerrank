package com.hackerrank.hashmap;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import static org.junit.Assert.*;

public class RansomNoteTest {
    String[] magazine;
    String[] note;

    @Test
    public void checkMagazine() throws IOException {
        parseInputData(7, 4, "ranote-01.data");
        RansomNote.checkMagazine(magazine, note);
    }


    @Test
    public void testHashMap() {
        HashMap<String, Integer> hmap = new HashMap<>();
        hmap.put("a", 1);
        hmap.put("b", 2);
        hmap.put("c", 3);

        System.out.println(hmap.put("c", 4));

    }


    private void parseInputData(int n, int m, String fileName) throws IOException {
        magazine = new String[n];
        note = new String[m];

        InputStream is = ClassLoader.getSystemResourceAsStream("hashmap/" + fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        magazine = reader.readLine().split(" ");
        note = reader.readLine().split(" ");
    }

}