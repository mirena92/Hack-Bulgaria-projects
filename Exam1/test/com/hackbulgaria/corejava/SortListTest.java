package com.hackbulgaria.corejava;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class SortListTest {

    @Test
    public void testSort() {
        List<Integer> list = Arrays.asList(5, 2, 15, 8, 13);
        List<Integer> sortList = SortList.sort(list);

        assertTrue(sortList.get(0) == 2);
        assertTrue(sortList.get(sortList.size() - 1) == 15);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(2);
        list1.add(15);
        list1.add(8);
        list1.add(13);
        List<Integer> sortList1 = SortList.sort(list1);
        assertTrue(sortList1.get(0) == 2);
        assertTrue(sortList1.get(sortList1.size() - 1) == 15);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(5);
        list2.add(2);
        list2.add(15);
        list2.add(8);
        list2.add(13);
        List<Integer> sortList2 = SortList.sort(list2);
        assertTrue(sortList2.get(0) == 2);
        assertTrue(sortList2.get(sortList2.size() - 1) == 15);
    }

    @Test
    public void testBubbleSort() {
        List<Integer> list = Arrays.asList(5, 2, 15, 8, 13);
        List<Integer> sortList = SortList.bubbleSort(list);
        assertTrue(sortList.get(0) == 2);
        assertTrue(sortList.get(sortList.size() - 1) == 15);

        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(2);
        list1.add(15);
        list1.add(8);
        list1.add(13);
        List<Integer> sortList1 = SortList.bubbleSort(list1);
        assertTrue(sortList1.get(0) == 2);
        assertTrue(sortList1.get(sortList1.size() - 1) == 15);

        List<Integer> list2 = new LinkedList<>();
        list2.add(5);
        list2.add(2);
        list2.add(15);
        list2.add(8);
        list2.add(13);
        List<Integer> sortList2 = SortList.bubbleSort(list2);
        assertTrue(sortList2.get(0) == 2);
        assertTrue(sortList2.get(sortList2.size() - 1) == 15);
    }
}
