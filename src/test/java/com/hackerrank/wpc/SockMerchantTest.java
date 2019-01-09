package com.hackerrank.wpc;

import org.junit.Test;

import static com.hackerrank.wpc.SockMerchant.scokMerchant;
import static org.junit.Assert.*;

public class SockMerchantTest {

    @Test
    public void testSockMerchant() {
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};

        System.out.println(scokMerchant(ar.length, ar));
        assertEquals(3, scokMerchant(ar.length, ar));
    }

}