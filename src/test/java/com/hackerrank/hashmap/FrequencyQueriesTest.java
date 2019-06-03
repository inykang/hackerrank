package com.hackerrank.hashmap;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class FrequencyQueriesTest {

    @Test
    public void testFreqQuery() throws IOException {
        String cs = "01";  //100000,
        List<List<Integer>> queries = parseInputData("freqqueries-" + cs +".data");
        List<Integer> answers = FrequencyQueries.freqQuery(queries);
        List<Integer> corrAnswers = parseAnswerData("freqqueries-" + cs +".ans");
        for (int i = 0; i < answers.size(); i++) {
            if (!answers.get(i).equals(corrAnswers.get(i))) {
                System.out.println(String.format(
                        "[%d], my ans: %d, ans: %d, correct: %b"
                        , i
                        , answers.get(i), corrAnswers.get(i)
                        , answers.get(i).equals(corrAnswers.get(i))
                ));
                break;
            }
        }
        //System.out.println("output: " + answers.toString());
    }

    private List<Integer> parseAnswerData(String fileName) throws IOException {
        InputStream is = ClassLoader.getSystemResourceAsStream("hashmap/" + fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        List<Integer> answers = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            answers.add(Integer.valueOf(line));
        }
        return answers;
    }

    private List<List<Integer>> parseInputData(String fileName) throws IOException {
        InputStream is = ClassLoader.getSystemResourceAsStream("hashmap/" + fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        List<List<Integer>> queries = new ArrayList<>();
        String line;
        while ( (line = reader.readLine()) != null) {
            List<Integer> query =
            Arrays.stream(line.split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
           queries.add(query);
        }
        return queries;
    }

    @Test
    public void testRemoveWithValue() {
        List<Long> list = Stream.of(3,4,6,5,5,9,1)
                .map(Long::new)
                .collect(Collectors.toList());
        list.remove(1L);
        System.out.println(list.toString());
        list.remove(3);
        System.out.println(list.toString());
    }

}