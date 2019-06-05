package com.amz.assessment;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class PrimeAirTest {
    @Test
    public void testOptimalUtilization() {
        List<List<Integer>> forwardRouterList = new ArrayList<>();
        forwardRouterList.add(Arrays.asList(1, 8));
        forwardRouterList.add(Arrays.asList(2, 7));
        forwardRouterList.add(Arrays.asList(3, 14));

        List<List<Integer>> returnRouterList = new ArrayList<>();
        returnRouterList.add(Arrays.asList(1, 5));
        returnRouterList.add(Arrays.asList(2, 10));
        returnRouterList.add(Arrays.asList(3, 14));

        List<List<Integer>> answers =
                PrimeAir.optimalUtilization(20,
                        forwardRouterList, returnRouterList);

        System.out.println(answers.toString());
    }

    @Test
    public void testOptimalUtilization2() {
        List<List<Integer>> forwardRouterList = new ArrayList<>();
        forwardRouterList.add(Arrays.asList(1, 8));
        forwardRouterList.add(Arrays.asList(2, 15));
        forwardRouterList.add(Arrays.asList(3, 9));

        List<List<Integer>> returnRouterList = new ArrayList<>();
        returnRouterList.add(Arrays.asList(1, 8));
        returnRouterList.add(Arrays.asList(2, 11));
        returnRouterList.add(Arrays.asList(3, 12));

        List<List<Integer>> answers =
                PrimeAir.optimalUtilization(20,
                        forwardRouterList, returnRouterList);

        System.out.println(answers.toString());
    }

    @Test
    public void testOptimalUtilization3() {
        Integer[][] arrays = new Integer[][]{{1, 8}, {2, 15}, {3, 9}};
        List<List<Integer>> forwardRouterList = Arrays.stream(arrays)
                //.map(Integer::valueOf)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        System.out.println(forwardRouterList);
        Set<Character> charSet = new HashSet<>();
        charSet.toArray();
    }

    @Test
    public void testIntStream() {
        int[] arr = new int[]{1, 4, 3, 5, 7, 6};
        Arrays.stream(arr)
                .boxed()
                //.map(Integer::new)
                .collect(Collectors.toList())
        ;

        int[][] arrays = new int[][]{{1, 8}, {2, 15}, {3, 9}};
        //List<List<Integer>> list =
        System.out.println(
                Arrays.stream(arrays)
                        .flatMapToInt(Arrays::stream)
                        .boxed()
                        .map(Integer::new)
                        .collect(Collectors.toList()))
        ;



    }
}
