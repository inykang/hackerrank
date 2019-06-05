package com.hackerrank.string;

import org.junit.Test;

import java.util.*;

public class SherlockValidStringTest {
    @Test
    public void testIsValid() {
        String s = "abcdefghhgfedecba"; // "YES"
        String ans = SherlockValidString.isValid(s);
        System.out.println("answer: " + ans);
    }

    @Test
    public void testHashMapSet() {
        HashMap<Integer, List<Character>> countMap = new HashMap<>();
        countMap.put(new Integer(2), Arrays.asList('a', 'b'));
        countMap.put(new Integer(3), Arrays.asList('c', 'd'));
        countMap.put(new Integer(5), Arrays.asList('f', 'g'));

        Set<Integer> countSet = countMap.keySet();
        System.out.println(countSet.toString());
        Iterator<Integer> iter = countSet.iterator();
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());

        System.out.println(countMap.get(1));


    }

}