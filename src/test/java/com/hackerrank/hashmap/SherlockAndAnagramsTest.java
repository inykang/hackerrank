package com.hackerrank.hashmap;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SherlockAndAnagramsTest {

    @Test
    public void sherlockAndAnagrams() throws IOException {
        List<String> strs = parseInputData("anagram-02.data");
        for (String s : strs) {
            int count = SherlockAndAnagrams.sherlockAndAnagrams(s);
            System.out.println(count);
        }

    }

    private List<String> parseInputData(String fileName) throws IOException {
        InputStream is = ClassLoader.getSystemResourceAsStream("hashmap/" + fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        List<String> lines = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    @Test
    public void testDivideCharacters() {
        String s = "ifailuhkqq";
        int count = 0;
        char[] chars = s.toCharArray();
        int size = chars.length;
        for (int length = 1; length < size; length++) {
            for (int preIdx = 0; preIdx < size; preIdx++) {
                char[] pre = new char[length];
                System.arraycopy(chars, preIdx, pre, 0, length);
                for (int postIdx = preIdx + 1; postIdx + length <= size; postIdx++) {
                    char[] post = new char[length];
                    System.arraycopy(chars, postIdx, post, 0, post.length);
                    System.out.println(String.format(
                            "pre[%d, %d, %s], post[%d, %d, %s]"
                            , preIdx, preIdx + length, Arrays.toString(pre)
                            , postIdx, postIdx + length, Arrays.toString(post)
                    ));
                }

                if (preIdx + length + 1 >= size)
                    break;

            }
        }

    }

    @Test
    public void testDivide() {
        String s = "ifailuhkqq";
        List<Character> charList = new ArrayList<>();
        for (char c : s.toCharArray())
            charList.add(c);

        int size = charList.size();
        for (int length = 1; length < size; length++) {
            for (int preIndex = 0; preIndex < size; preIndex++) {
                List<Character> pre = charList.subList(preIndex, preIndex + length);
                for (int postIndex = preIndex + 1; postIndex + length <= size; postIndex++) {
                    List<Character> post = charList.subList(postIndex, postIndex + length);
                    System.out.println(String.format(
                            "pre[%d, %d, %s], post[%d, %d, %s]"
                            , preIndex, preIndex + length, pre.toString()
                            , postIndex, postIndex + length, post.toString()
                    ));

                }

                if (preIndex + length + 1 >= size)
                    break;
            }
        }
    }

    @Test
    public void testList() {
        List<Character> charList = new ArrayList<>();
        charList.add('a');
        charList.add('b');
        charList.add('c');
        charList.add('a');

        System.out.println(charList.remove(new Character('a')));
        System.out.println(charList.toString());
    }

}