package com.hackerrank.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyQueries {
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        //value, count map
        HashMap<Integer,Integer> valueMap = new HashMap<>();
        //count, value list map
        HashMap<Integer, List<Integer>> countMap = new HashMap<>();
        //answer list
        List<Integer> answers = new ArrayList<>();

        for (List<Integer> query : queries) {
            Integer operation = query.get(0);
            //insert
            if (operation.equals(1)) {
                Integer x = query.get(1);
                Integer count = valueMap.getOrDefault(x, 0);
                Integer newCount = count + 1;
                valueMap.put(x, newCount);
                if (countMap.containsKey(count)) {
                    countMap.get(count).remove(x);
                    if (countMap.get(count).isEmpty()) {
                        countMap.remove(count);
                    }
                }
                List<Integer> valueList = countMap.get(newCount);
                if (valueList == null) {
                    valueList = new ArrayList<>();
                }
                valueList.add(x);
                countMap.put(count + 1, valueList);
                //delete
            } else if (operation.equals(2)) {
                Integer y = query.get(1);
                Integer count = valueMap.getOrDefault(y, 0);
                if (count > 0) {
                    List<Integer> valueList = countMap.get(count);
                    if (valueList != null) {
                        valueList.remove(y);
                        if (valueList.isEmpty()) {
                            countMap.remove(count);
                        }
                    }
                    Integer newCount = valueMap.get(y) -1;
                    valueMap.put(y, newCount);
                    if (newCount > 0) {
                        valueList = countMap.get(newCount);
                        if (valueList ==  null) {
                            valueList = new ArrayList<>();
                        }
                        valueList.add(y);
                        countMap.put(newCount, valueList);
                    }
                }
                //check
            } else {
                Integer z = query.get(1);
                if (countMap.containsKey(z)) {
                    answers.add(1);
                } else {
                    answers.add(0);
                }
                //System.out.println("===>" + answers.toString());
            }
//            System.out.println(String.format(
//                    "(%d, %d)\n%s\n%s"
//                    , operation, query.get(1)
//                    , valueMap.toString()
//                    , countMap.toString()
//            ));
        }
        return answers;
    }

}