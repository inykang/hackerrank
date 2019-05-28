package com.hackerrank.hashmap;

import java.util.HashSet;

public class TwoStrings {

    static String twoStrings(String s1, String s2) {
        HashSet<Character> charSet = new HashSet<>();
        for(char c : s1.toCharArray()) {
            charSet.add(c);
        }

        for (char c : s2.toCharArray()) {
            if (charSet.contains(c))
                return "Yes";
        }
        return "No";
    }
}
