package com.hackerrank;

import org.junit.Test;

import java.io.InputStream;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

public class HackerRankTest {

    @Test
    public void testHashSet() {
        Set<String> set = new HashSet<>();
        set.add("");
        System.out.println(set.size());
    }

    @Test
    public void testScan() {
        InputStream is = ClassLoader.getSystemResourceAsStream("data/scan.data");
        //Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(is);
        int i = scan.nextInt();

        double d = scan.nextDouble();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s = scan.next();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }

    @Test
    public void outputFormatting() {
        InputStream is = ClassLoader.getSystemResourceAsStream("data/formatting.data");
        Scanner scan = new Scanner(is);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = scan.next();
            int x = scan.nextInt();
            //Complete this line
            System.out.printf("%-15s%03d\n", s1, x);
        }
        System.out.println("================================");
    }

    @Test
    public void loop2() {
        InputStream is = ClassLoader.getSystemResourceAsStream("data/loop2.data");
        Scanner in = new Scanner(is);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for (int p = 0; p < n; p++) {
                int per = 0;
                for (int q = 0; q <= p; q++)
                    per = per + (int) Math.pow(2, q);
                System.out.printf("%d ", a + (b * per));
            }

            System.out.print("\n");
        }
        in.close();
    }

    @Test
    public void test() {
        System.out.println(Math.pow(-2, 31));
        System.out.println(Math.pow(2, 31));
    }

    @Test
    public void datatypes() {
        InputStream is = ClassLoader.getSystemResourceAsStream("data/datatypes2.data");
        Scanner sc = new Scanner(is);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");
                if (x >= -128 && x <= 127) System.out.println("* byte");
                //Complete the code
                if (x >= -32768 && x <= 32767) System.out.println("* short");
                if (x >= Math.pow(-2, 31) && x <= Math.pow(2, 31) -1) System.out.println("* int");
                if (x >= Math.pow(-2, 63) && x <= Math.pow(2, 63) -1) System.out.println("* long");
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
        }
    }

    @Test
    public void endOfFile() {
        InputStream is = ClassLoader.getSystemResourceAsStream("data/endOfFile.data");
        Scanner sc = new Scanner(is);
        int index = 1;
        while (sc.hasNext()) {
            System.out.println(String.format("%d %s",  index, sc.nextLine()));
            index ++;
        }
    }

    @Test
    public void printAbsolutePath() {
        System.out.println(ClassLoader.getSystemResource(".").getPath());
        System.out.println(ClassLoader.getSystemResource("data/aaa.txt").getPath());
        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void dateTime() {
        int m = 8;
        int d = 5;
        int y = 2015;
        LocalDate date = LocalDate.of(y, m, d);
        System.out.println(date.getDayOfWeek());
    }

    @Test
    public void currencyFormat() {
        double payment = 12324.134;
        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String india = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }

    @Test
    public void comparator() {
        String s1 = "aabdd";
        String s2 = "cccsd";

        List<String> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        Arrays.sort(list.toArray());

        System.out.println(s1.compareTo(s2));
        System.out.println(list);
    }

}
