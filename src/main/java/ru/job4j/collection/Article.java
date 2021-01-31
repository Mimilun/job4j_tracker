package ru.job4j.collection;

import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {

        origin = origin.replaceAll("\\p{Punct}", "");
        line = line.replaceAll("\\p{Punct}", "");

        String[] arrOr = origin.split(" ");
        String[] arrLine = line.split(" ");

        Map<String, Integer> mapOr = new HashMap<>();
        final int value = 0;

        for (String s : arrOr) {
            mapOr.put(s, value);
        }

        boolean res = true;
        for (String s : arrLine) {
            if (!mapOr.containsKey(s)) {
                res = false;
                break;
            }
        }
        return res;
    }
}
