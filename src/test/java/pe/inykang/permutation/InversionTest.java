package pe.inykang.permutation;

import org.junit.Test;

import static org.junit.Assert.*;

public class InversionTest {

    @Test
    public void getInvCount() {
        int [] arr = new int[] {1, 20, 6, 4, 5};
        int invCount = Inversion.getInvCount(arr);
        System.out.println("inversion count: " + invCount);
    }
}