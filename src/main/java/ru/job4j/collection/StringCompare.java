package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int i = 0;
        while (i < left.length() && i < right.length()) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.charAt(i) - right.charAt(i);
            }
            i++;
        }
        return left.length() - right.length();
    }
}