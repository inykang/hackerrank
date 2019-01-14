package com.hackerrank.array;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class NewYearChaosTest {

    /**
     * nyc-05.data => 96110
     * @throws IOException
     * @throws URISyntaxException
     */
    @Test
    public void minimumBribes() throws IOException, URISyntaxException {
        List<String> lines = parseInData("array/nyc-02-2.data");
        for (int i = 0; i < lines.size(); i++) {
            if (i % 2 != 0) {
                long s = System.currentTimeMillis();
                System.out.println("==============================================");
                NewYearChaos.minimumBribes(convertIntArrays(lines.get(i)));
                System.out.println(String.format(
                        "elapsed: %,d ms",
                        System.currentTimeMillis() -s
                ));
            }
        }
    }

    private int[] convertIntArrays(String line) {
        String[] strs  = line.split(" ");
        int len = strs.length;
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = Integer.parseInt(strs[i]);
        }
        return ints;
    }

    private List<String> parseInData(String fileName) throws URISyntaxException, IOException {
        return Files
                .lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))
                .skip(1)
                .collect(Collectors.toList())
                ;
    }
}