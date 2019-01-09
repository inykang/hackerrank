package com.hackerrank;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class PlayerComparator {
    public static void main(String[] args) {
        InputStream is = ClassLoader.getSystemResourceAsStream("data/player.data");
        Scanner sc = new Scanner(is);
        int n = sc.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(sc.next(), sc.nextInt());
        }
        sc.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < n; i++) {
            System.out.println(String.format("%s %s", player[i].name, player[i].score));
        }

    }
}
