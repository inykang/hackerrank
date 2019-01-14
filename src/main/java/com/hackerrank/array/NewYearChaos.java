package com.hackerrank.array;

import java.util.*;

public class NewYearChaos {
    static void minimumBribes(int[] q) {
        System.out.println(Arrays.toString(q));

        List<Integer> forward = new ArrayList<>();
        Map<Integer, Integer> backward = new HashMap<>();

        int len = q.length;
        int count = 0;

        for (int i = 0; i < len -1; i++) {
            int val = q[i];
            int move = val - i - 1;

            if (move > 2) {
                count = -1;
                break;
            }

            if (move > 0) {
                count = count + move;
                addBackward(forward, backward, move, q[i]);
                forward.add(val);
            } else {
                int bc = 0;
                if (backward.get(val) != null) {
                    bc = backward.get(val);
                    backward.remove(val);
                    if (bc + move >= 0) {
                        forward.add(val);
                        count = count + bc + move;
                    }
                }
                //forward = arrageForward(forward, backward);
            }

            if (i > 1)
            forward.remove(new Integer(i - 1));

            for (Integer v : backward.keySet()) {
                backward.put(v, backward.get(v) + 1);
            }

            //countBackward(forward, backward, i, val);

            System.out.println(String.format(
                    "val: %d\nforward: %s\nbackward: %s \nmove: %d, count: %d",
                    val, forward, backward, move, count
            ));

        }

        System.out.println("---------");

        if (count > 0)
            System.out.println(count);
        else
            System.out.println("Too chaotic");
    }

    private static void addBackward(
            List<Integer> forward, Map<Integer, Integer> backward, int move, int idx
    ) {
        for (int i = idx - 1; i >= move ; i--) {
            if(!forward.contains(i)) {
                backward.put(i, 0);
            }
        }
    }

    private static List<Integer> arrageForward(List<Integer> forward, Map<Integer, Integer> backward) {
        List<Integer> temp = new ArrayList<>();

        for (Integer i : backward.keySet()) {
            if(forward.contains(i - 1))
                temp.add(i - 1);
            if((i - 2) > 0 && forward.contains(i - 2))
                temp.add(i - 2);
        }
        return temp;
    }

    private static void countBackward(
            List<Integer> forward, Map<Integer, Integer> backward, int cur, int pos
    ) {
        int s = cur - 1;
        if (s < 0)
            return;
        for (int i = s; i < pos; i++) {
            if (!forward.contains(i)) {
                Integer itg = backward.get(i);
                if (itg == null) itg = 1;
                else itg++;
                backward.put(i, itg);
            }
            forward.remove(new Integer(cur));
        }
    }

}
