package com.hackerrank.wpc;

public class RepeatedString {
    static long repeatedString(String s, long n) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        long single = countA(chars, len);
        long count = (n / len) * single;
        count = count + countA(chars, (n % len));

      return count;
    }

    static long countA(char[] chars, long len) {
        long count = 0L;
        for (int i = 0; i < len; i++) {
            if (chars[i] == 'a')
                count ++;
        }
        return count;
    }

}
