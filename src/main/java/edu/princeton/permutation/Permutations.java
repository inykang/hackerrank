package edu.princeton.permutation;

public class Permutations {
    private static int depth = 0;

    public static void perm1(String s) {
        perm1("", s);
    }

    public static void perm1(String prefix, String s) {
        int n = s.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
        }
    }

    public static void perm2(String s) {
        int n = s.length();
        char[] a = new char[n];
        for (int i = 0; i < n; i++)
            a[i] = s.charAt(i);
        perm2(a, n);
    }

    public static void perm2(char[] a, int n) {
        System.out.println("depth in: " + ++depth + ", n: " + n);
        if (n == 1) {
            System.out.println(new String(a));
            System.out.println("depth out: " + --depth + ", n: " + n);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            perm2(a, n-1);
            swap(a, i, n-1);
        }
    }

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        System.out.printf("depth(%d): swap(%d,%d): %s => ",depth, i, j, String.valueOf(a));
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
        System.out.print(String.valueOf(a) + "\n");
    }
}
