package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {

        String[] arrLeft = left.split("\\D+");
        int numLeft = Integer.parseInt(arrLeft[0]);

        String[] arrRight = right.split("\\D+");
        int numRight = Integer.parseInt(arrRight[0]);

        return Integer.compare(numLeft, numRight);
    }
}
