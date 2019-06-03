package com.hackerrank.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyQueries {
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        //main map, key: x,
        HashMap<Integer, Integer> valueMap = new HashMap<>();

        //count map, key: count, value: List of x
        HashMap<Integer, List<Integer>> countMap = new HashMap<>();

        //answer list
        List<Integer> answer = new ArrayList<>();

        for (List<Integer> query : queries) {
            Integer operation = query.get(0);
            //insert
            switch (operation.intValue()) {
                case 1:
                    Integer x = query.get(1);
                    Integer count = valueMap.getOrDefault(x, 0) + 1;
                    valueMap.put(x, count);
                    if (countMap.containsKey(count)) {
                        countMap.get(count).add(x);
                    } else {
                        List<Integer> valueList = new ArrayList<>();
                        valueList.add(x);
                        countMap.put(count, valueList);
                    }

                    count = count - 1;
                    if (countMap.containsKey(count)) {
                        countMap.get(count).remove(x);
                    }
                    break;
                case 2:
                    Integer y = query.get(1);
                    Integer countY = valueMap.getOrDefault(y, 0);
                    if (countY > 0L) {
                        if (countMap.containsKey(countY)) {
                            countMap.get(countY).remove(y);
                            countY = countY - 1;
                            if (countY > 0L) {
                                if (countMap.containsKey(countY)) {
                                    countMap.get(countY).add(y);
                                } else {
                                    List<Integer> valueList = new ArrayList<>();
                                    valueList.add(y);
                                    countMap.put(countY, valueList);
                                }
                                valueMap.put(y, valueMap.get(y) + 1);
                            }
                        }
                    }

                    break;
                case 3:
                    Integer z = query.get(1);
                    if (countMap.containsKey(z)) {
                        if (countMap.get(z).isEmpty())
                            answer.add(0);
                        else
                            answer.add(1);
                    } else {
                        answer.add(0);
                    }
                    break;
            }
        }
        return answer;
    }
}