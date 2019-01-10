package com.hackerrank.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkSchedule {
    private static int fillCount = 0;
    private static int workedHours = 0;
    private static List<int[]> schedules = new ArrayList<>();

    public static void findSchedule(int workHours, int dayHours, String pattern) {
        prepare(pattern);
        int toDoWorkHours = workHours - workedHours;
        int[] candidates = initCandidate(dayHours);

        CombinationRepetition(candidates, candidates.length, fillCount);

        for(int[] ints : schedules) {
            //System.out.println("Arrays: " + Arrays.toString(ints));
            if (sum(ints) == toDoWorkHours)
                System.out.println("String: " + replaceQuestions(ints, pattern));
        }
        //.forEach(ints -> System.out.println(Arrays.toString(ints)));
    }

    private static String replaceQuestions(int[] schedules, String pattern) {
        char[] chars = pattern.toCharArray();
        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                chars[i] = (char) (schedules[idx] + '0');
                idx++;
            }
        }
        return new String(chars);
    }

    private static int sum(int[] ints) {
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum = sum + ints[i];
        }
        return sum;
    }

    private static int[] initCandidate(int dayHours) {
        int[] ints = new int[dayHours + 1];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        return ints;
    }

    private static void prepare(String patterns) {
        char[] chars = patterns.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') fillCount++;
            else
                workedHours = workedHours + Character.getNumericValue(chars[i]);
        }
    }

    static void CombinationRepetition(int arr[], int n, int r) {
        // Allocate memory
        int chosen[] = new int[r + 1];

        // Call the recursice function
        CombinationRepetitionUtil(chosen, arr, 0, r, 0, n - 1);
    }

    static void CombinationRepetitionUtil(int chosen[], int arr[],
                                          int index, int r, int start, int end) {
        // Since index has become r, current combination is
        // ready to be printed, print
        if (index == r) {
            int[] comb = new int[r];
            for (int i = 0; i < r; i++) {
                comb[i] = arr[chosen[i]];
            }
            schedules.add(comb);
            return;
        }

        // One by one choose all elements (without considering
        // the fact whether element is already chosen or not)
        // and recur
        for (int i = start; i <= end; i++) {
            chosen[index] = i;
            CombinationRepetitionUtil(chosen, arr, index + 1,
                    r, i, end);
        }
        return;
    }

}
