package com.hackerrank.array;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class HourGlassSumTest {

    @Test
    public void hourglassSum() throws IOException {
        int[][] arr = parseInputData("02.data");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("max: " + HourGlassSum.hourglassSum(arr));
    }

    private int[][] parseInputData(String fileName) throws IOException {
        int[][] arr = new int[6][6];
        InputStream is = ClassLoader.getSystemResourceAsStream("array/" + fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        int row = 0;
        while ((line = reader.readLine()) != null) {
            String[] strs = line.split(" ");
            for (int col = 0; col < strs.length; col++) {
                arr[row][col] = Integer.parseInt(strs[col]);
            }
            row ++;
        }

        return arr;
    }

    @Test
    public void count2DArray() {
        int[][] arr = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0}
        };

        System.out.println(arr.length);
    }
}