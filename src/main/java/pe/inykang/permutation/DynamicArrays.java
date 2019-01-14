package pe.inykang.permutation;

import java.util.Arrays;

public class DynamicArrays {

    public static void fillout(int[] base, int[] ans, int c) {
        if (ans.length == c) {
            System.out.println(Arrays.toString(ans));
            return;
        }

        for (int i = 0; i < base.length; i++) {
            ans[c] = base[i];
            fillout(base, ans, c + 1);
        }
    }

    public static void create(int[] base, int r) {
        int[] ans = new int[r];
            fillout(base, ans, 0);
    }
}
