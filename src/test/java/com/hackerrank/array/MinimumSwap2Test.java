package com.hackerrank.array;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSwap2Test {

    /**
     * minswap-01: 5, minswap-02: 2, minswap-03: 3, minswap-04: 3, minswap-05: 3
     * minswap-06: 91, minswap-07: 495, minswap-08: 991
     * @throws IOException
     * @throws URISyntaxException
     */
    @Test
    public void minimumSwaps() throws IOException, URISyntaxException {
        int swap = MinimumSwap2.minimumSwaps(parseInData("array/minswap-06.data"));
        System.out.println(swap);
    }

    private int[] parseInData(String file) throws URISyntaxException, IOException {
        return
                Files.lines(Paths.get(ClassLoader.getSystemResource(file).toURI()))
                        .skip(1)
                        .flatMap(line -> Arrays.stream(line.split(" ")))
                        .mapToInt(Integer::parseInt)
                        .toArray()
                ;
    }

    @Test
    public void listIndex() {
        List<Integer> ints = Arrays.asList(1,3,4,5,6,2);
        for (int i = 0; i < ints.size(); i++) {
            System.out.println(ints.indexOf(ints.get(Integer.valueOf(i))));
        }
    }
}