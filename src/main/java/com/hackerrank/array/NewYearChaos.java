package com.hackerrank.array;

import java.util.*;

public class NewYearChaos {
    static void minimumBribes(int[] q) {
        System.out.println(Arrays.toString(q));

        List<Integer> forward = new ArrayList<>();
        Set<Integer> backward = new HashSet<>();

        int len = q.length;
        int count = 0;

        for (int i = 0; i < len - 1; i++) {
            int val = q[i];
            int move = val - i - 1;

            if (move > 2) {
                count = -1;
                break;
            }

            if (move > 0) {
                count = count + move;
                forward.add(val);
                addBackward(forward, backward, move, val);

            } else {
                int bc = countBackSteps(forward, val);
                if (bc + move > 0) {
                    forward.add(val);
                    count = count + bc + move;
                }
                backward.remove(new Integer(val));
            }
            pruneForward(forward, backward);

            System.out.println(String.format(
                    "val: %d\nforward: %s\nbackward: %s\nmove: %d, count: %d",
                    val, forward, backward, move, count
            ));

        }

        System.out.println("---------");
        if (count > 0)
            System.out.println(count);
        else
            System.out.println("Too chaotic");
    }

    private static void pruneForward(List<Integer> forward, Set<Integer> backward) {
        int min = minBackward(backward);
        for (int i = 0; i < forward.size(); i++) {
            Integer v = forward.get(i);
            if (v < min) forward.remove(v);
        }
    }

    private static void addBackward(List<Integer> forward, Set<Integer> backward, int move, int val) {
        for (int i = 0; i < move; i++) {
            Integer v = val -1 -i;
            if (!forward.contains(v))
                backward.add(val - 1 - i);
        }
    }

    private static int minBackward(Set<Integer> backward) {
        int min = 0;
        for (Integer i : backward) {
            if (min == 0 || min > i)
                min = i;
        }
        return min;
    }

    private static int countBackSteps(List<Integer> forward, int val) {
        int steps = 0;
        for (Integer k : forward)
            if (k >= val)
                steps = steps + 1;

        return steps;
    }
}
