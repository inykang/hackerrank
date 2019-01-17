package com.hackerrank.array;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SparseArrays {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        Map<String, Long> count =
                Arrays.stream(strings)
                        .filter(s -> Arrays.asList(queries).contains(s))
                        .collect(Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        ));

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Long v = count.get(queries[i]);
            if (v == null) v = 0L;
            ans[i] = Math.toIntExact(v);
        }

        return ans;
    }
}
