package com.hackerrank.wpc;

import java.util.HashMap;
import java.util.Map;

public class SockMerchant {

    static int scokMerchant(int n, int[] ar) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            Integer k = ar[i];
            Integer val = map.get(k);
            if (val == null)
                map.put(k, 1);
            else
                map.put(k, val + 1);
        }

        int rst = 0;
        for(Integer k : map.keySet())
            rst = rst + (map.get(k) / 2);

        return rst;
    }
}
