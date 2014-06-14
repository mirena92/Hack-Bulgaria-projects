package com.hackbulgaria.corejava;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {

    public static List<Integer> reverseList(List<Integer> inputList) {
        List<Integer> outputList = null;

        if (inputList instanceof LinkedList) {
            outputList = new LinkedList<Integer>(inputList);
        } else
            outputList = new ArrayList<>(inputList);

        for (int i = inputList.size() - 1; i >= 0; i--) {
            outputList.set(inputList.size() - 1 - i, inputList.get(i));
        }

        return outputList;
    }
}
