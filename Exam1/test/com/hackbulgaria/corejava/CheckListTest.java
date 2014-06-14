package com.hackbulgaria.corejava;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CheckListTest {

    @Test
    public void testIsMonotous() {
        assertTrue(CheckList.isMonotonous(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertTrue(CheckList.isMonotonous(Arrays.asList(6, 5, 4, 3, 2, 1, 1, 1)));
        assertFalse(CheckList.isMonotonous(Arrays.asList(1, 2, 1, 4, 5, 4)));
    }

}
