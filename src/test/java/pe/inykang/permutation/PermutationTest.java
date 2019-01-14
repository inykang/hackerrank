package pe.inykang.permutation;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class PermutationTest {

    @Test
    public void permute() {
        //int arr[] = {1,2,3,4,5,6,7,8};
        int arr[] = {1,2,3,4};
        int r = 4;

        Permutation perm = new Permutation();
        perm.permute(arr, arr.length, r);

        AtomicInteger ai = new AtomicInteger();
        perm.getList().forEach(ints ->
                System.out.println(ai.incrementAndGet() + ":" + Arrays.toString(ints))
        );
    }
}