package com.hackerrank.array;

import java.util.*;

public class NewYearChaos {
    static void minimumBribes(int[] q) {
        List<Integer> forward = new ArrayList<>();
        Map<Integer, Integer> backward = new HashMap<>();

        int len = q.length;
        int count = 0;

        for (int i = 0; i < len - 1; i++) {
            int move = q[i] - i -1;

            if (move > 2) {
                count = -1;
                break;
            }

            if (move > 0) {
                count = count + move;
                forward.add(q[i]);
            } else {
                int wc = 0;
                if(backward.get(q[i]) != null) wc = backward.get(q[i]);
                count = count + wc + move;
                forward.add(q[i]);
                backward.remove(q[i]);
            }
            countBackward(forward, backward, i, q[i]);


            System.out.println(String.format(
                    "forward: %s\nbackward: %s \nmove: %d, count: %d",
                    forward, backward, move, count
            ));

        }

        System.out.println("---------");

        if (count > 0)
            System.out.println(count);
        else
            System.out.println("Too chaotic");
    }

    private static void countBackward(
            List<Integer> forward, Map<Integer, Integer> backward, int cur, int pos
    ) {
        for (int i = cur - 1; i < pos; i++) {
            if (!forward.contains(i)) {
                Integer itg = backward.get(i);
                if (itg == null) itg = 1;
                else itg ++;
                backward.put(i, itg);
            }
            forward.remove(new Integer(cur));
        }
    }

}
