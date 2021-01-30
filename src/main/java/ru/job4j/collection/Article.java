package ru.job4j.collection;

import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {

        origin = origin.replaceAll("\\p{Punct}", "");
        line = line.replaceAll("\\p{Punct}", "");
        String[] arrOr = origin.split(" ");
        String[] arrLine = line.split(" ");

        Map<String, Integer> mapOr = new HashMap<>();
        Map<String, Integer> mapLine = new HashMap<>();
        final int value = 0;
        boolean res = true;

        for (String s : arrOr) {
            mapOr.put(s, value);
        }
        for (String s : arrLine) {
            mapLine.put(s, value);
            if (mapOr.containsKey(s)) {
                mapLine.put(s, mapLine.get(s) + 1);
            }
        }

        for (Integer i : mapLine.values()) {
            if (i == 0) {
                res = false;
                break;
            }
        }
        return res;
    }
}
