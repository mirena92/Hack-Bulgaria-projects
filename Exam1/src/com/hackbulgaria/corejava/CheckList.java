package com.hackbulgaria.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckList {

    public static boolean isMonotonous(List<Integer> list) {
        List<Integer> copy = new ArrayList<>(list);

        Collections.sort(copy);
        if (list.equals(copy)) {
            return true;
        }

        Collections.reverse(copy);
        if (list.equals(copy)) {
            return true;
        }
        return false;
    }
}
