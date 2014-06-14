package com.hackbulgaria.corejava;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ReverseListTest {

    @Test
    public void testReverseList() {
        List<Integer> list = Arrays.asList(1, 3, 5, 7);
        List<Integer> reversedList = ReverseList.reverseList(list);
        assertEquals(Arrays.asList(7, 5, 3, 1), reversedList);

        list = Arrays.asList(5, 8, 1, 1, 4);
        reversedList = ReverseList.reverseList(list);
        assertEquals(Arrays.asList(4, 1, 1, 8, 5), reversedList);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(5);
        list2.add(2);
        list2.add(15);
        list2.add(8);
        list2.add(13);
        reversedList = ReverseList.reverseList(list2);
        assertEquals(Arrays.asList(13, 8, 15, 2, 5), reversedList);
    }

}
