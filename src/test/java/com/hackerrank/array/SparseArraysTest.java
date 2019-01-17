package com.hackerrank.array;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SparseArraysTest {

    @Test
    public void matchingStrings() throws URISyntaxException, IOException {
        List<String> data = new ArrayList<>();
        List<String> queries = new ArrayList<>();
        AtomicBoolean isData = new AtomicBoolean(true);
        Files.lines(
                Paths.get(
                        ClassLoader.getSystemResource("array/sparse-01.data")
                                .toURI()
                )
        )
                .skip(1)
                .forEach(s -> {
                    if (isNumeric(s)) {
                        isData.set(false);
                        return;
                    }
                    if (isData.get())
                        data.add(s);
                    else
                        queries.add(s);
                })
        ;

        int[] ans =
                SparseArrays.matchingStrings(
                        data.stream().toArray(String[]::new),
                        queries.stream().toArray(String[]::new)
                );
        System.out.println(Arrays.toString(ans));
    }

    private boolean isNumeric(String str) {
        if (str.length() == 1) {
            char[] chars = str.toCharArray();
            if (Character.isDigit(chars[0]))
                return true;
        }
        return false;
    }
}