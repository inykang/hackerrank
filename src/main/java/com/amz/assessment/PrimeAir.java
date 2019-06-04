package com.amz.assessment;

import java.util.ArrayList;
import java.util.List;

public class PrimeAir {

    static List<List<Integer>> optimalUtilization(int maxTravelDis,
                                                  List<List<Integer>> forwardRouterList,
                                                  List<List<Integer>> returnRouterList) {
        List<List<Integer>> answers = new ArrayList<>();
        int maxSumDist = 0;
        for (int i = 0; i < forwardRouterList.size(); i++) {
            Integer forwardIdx = forwardRouterList.get(i).get(0);
            int forwardDist = forwardRouterList.get(i).get(1).intValue();

            for (int j = 0; j < returnRouterList.size(); j++) {
                Integer returnIdx = returnRouterList.get(j).get(0);
                int returnDist = returnRouterList.get(j).get(1).intValue();

                int sumDist = forwardDist + returnDist;
                if (sumDist <= maxTravelDis  && sumDist >= maxSumDist) {
                    if (sumDist > maxSumDist) {
                        maxSumDist = sumDist;
                        answers = new ArrayList<>();
                    }
                    List<Integer> answer = new ArrayList<>();
                    answer.add(forwardIdx);
                    answer.add(returnIdx);
                    answers.add(answer);
                }
            }
        }
        return answers;
    }
}
