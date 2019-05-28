package com.hackerrank.hashmap;

import java.util.ArrayList;
import java.util.List;

public class SherlockAndAnagrams {
    static int sherlockAndAnagrams(String s) {
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
                    if (isAnagrams(pre, post))
                        count++;
                }

                if (preIdx + length + 1 >= size)
                    break;

            }
        }

        //int size = charList.size();
//        for (int length = 1; length < size; length++) {
//            for (int preIndex = 0; preIndex < size; preIndex++) {
//                List<Character> pre = charList.subList(preIndex, preIndex + length).;
//
//                for (int postIndex = preIndex + 1; postIndex + length <= size; postIndex++) {
//                    List<Character> post = charList.subList(postIndex, postIndex + length);
//                    if (isAnagrams(pre, post))
//                        count ++;
//                }
//
//                if (preIndex + length + 1 >= size)
//                    break;
//            }
//        }
        return count;
    }

    static boolean isAnagrams(char[] pre, char[] post) {
        List<Character> preList = new ArrayList<>();
        for (Character preChar : pre) {
            preList.add(preChar);
        }

        for (char postChar : post) {
            if (!preList.remove(new Character(postChar)))
                return false;
        }
        return true;
    }

    static boolean isAnagrams(List<Character> pre, List<Character> post) {
        for (Character c : pre) {
            if (!post.remove(new Character(c)))
                return false;
        }
        return true;
    }
}
