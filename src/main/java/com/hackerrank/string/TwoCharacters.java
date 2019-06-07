package com.hackerrank.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoCharacters {
    // Complete the alternate function below.
    static int alternate(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int[] maxTwo = new int[]{0, 0};
        Character pre = null;
        List<Character> removed = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            Character c = new Character(ch);

            if (removed.contains(c)) continue;

            if (pre != null && pre.equals(c)) {
                charMap.remove(c);
                removed.add(c);
            } else {
                int count = charMap.getOrDefault(c, 0) + 1;

                charMap.put(c, count);
            }


            pre = c;
//            if (maxTwo[1] < count) {
//                if (maxTwo[0] < count) {
//                    maxTwo[0] = count;
//                } else {
//                    maxTwo[1] = count;
//                }
//            }
        }
        if (charMap.keySet().size() > 1) {
            return maxTwo[0] + maxTwo[1];
        }

        return 0;
    }
}
