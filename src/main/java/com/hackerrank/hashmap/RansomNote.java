package com.hackerrank.hashmap;

import java.util.HashMap;

public class RansomNote {
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> magazineMap = convertHashMap(magazine);
        HashMap<String, Integer> noteMap = convertHashMap(note);

        String output = "Yes";
        for (String word : noteMap.keySet()) {
            Integer count = magazineMap.get(word);
            if (count == null || (magazineMap.get(word) < noteMap.get(word)))
                output = "No";
        }

        System.out.println(output);
    }

    static HashMap<String, Integer> convertHashMap(String[] inArr) {
        HashMap<String, Integer> hmap = new HashMap<>();
        for (String key : inArr) {
            Integer count = hmap.get(key);
            if (count == null) hmap.put(key, 1);
            else hmap.put(key, hmap.get(key) + 1);
        }
        return hmap;
    }
}
