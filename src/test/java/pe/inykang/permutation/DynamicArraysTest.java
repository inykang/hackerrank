package pe.inykang.permutation;

import org.junit.Test;

import static org.junit.Assert.*;

public class DynamicArraysTest {

    @Test
    public void create() {
        int base[] = {1,2,3,4,5};
        int r = 3;

        DynamicArrays.create(base, r);
    }
}