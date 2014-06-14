package com.hackbulgaria.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortList {

    // sort with collection.sort
    public static List<Integer> sort(List<Integer> inputList) {
        List<Integer> outputList = null;

        if (inputList instanceof LinkedList) {
            outputList = new LinkedList<Integer>(inputList);
        } else
            outputList = new ArrayList<>(inputList);

        Collections.sort(outputList);
        return outputList;
    }

    // sort with bubble sort
    public static List<Integer> bubbleSort(List<Integer> inputList) {
        List<Integer> outputList = null;
        int currentElement;

        if (inputList instanceof LinkedList) {
            outputList = new LinkedList<Integer>(inputList);
        } else
            outputList = new ArrayList<>(inputList);

        for (int i = 0; i < outputList.size() - 1; i++) {
            for (int j = i + 1; j < outputList.size(); j++) {
                if (outputList.get(i) > outputList.get(j)) {
                    currentElement = outputList.get(i);
                    outputList.set(i, outputList.get(j));
                    outputList.set(j, currentElement);
                }
            }
        }
        return outputList;
    }
}