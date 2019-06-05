package com.hackerrank.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SherlockValidString {
    // Complete the isValid function below.
    static String isValid(String s) {
        //character, count map
        HashMap<Character, Integer> charMap = new HashMap<>();
        //count, character list map
        HashMap<Integer, List<Character>> countMap = new HashMap<>();

        List<Character> charList;
        for (Character c : s.toCharArray()) {
            Integer count = charMap.getOrDefault(c, 0);
            //remove character from char list.
            charList = countMap.get(count);
            if (charList != null) {
                charList.remove(c);
                if (charList.isEmpty()) {
                    countMap.remove(count);
                }
            }

            count = count + 1;
            //put char into char map.
            charMap.put(c, count);

            charList = countMap.get(count);
            if (charList == null) {
                charList = new ArrayList<>();
            }
            charList.add(c);
            countMap.put(count, charList);
        }

        int size = countMap.keySet().size();
        if ( size == 1) {
            return "YES";
        } else if (size == 2) {
            Iterator<Integer> countItr = countMap.keySet().iterator();
            Integer fstCnt = countItr.next();
            Integer sndCnt = countItr.next();
            Integer min = Math.min(fstCnt, sndCnt);
            Integer max = Math.max(fstCnt, sndCnt);
            if ((countMap.get(max).size() == 1 && (max - min) == 1)
                    || (countMap.get(min).size() == 1 && min.equals(1))) {
                return "YES";
            }
        }
        return "NO";
    }

}
