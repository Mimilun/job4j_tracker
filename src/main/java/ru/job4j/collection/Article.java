package ru.job4j.collection;

import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {

        List<String> listOr = new ArrayList<>(Arrays.asList(origin.split("[,.;:!? ]")));
        List<String> listLine = new ArrayList<>(Arrays.asList(line.split("[,.;:!? ]")));
        listOr.removeAll(Arrays.asList(",", ".", ";", ":", "!", "?", ""));
        listLine.removeAll(Arrays.asList(",", ".", ";", ":", "!", "?", ""));

        Map<String, Integer> mapOr = new HashMap<>();
        Map<String, Integer> mapLine = new HashMap<>();
        final int value = 0;
        boolean res = true;

        for (String s : listOr) {
            mapOr.put(s, value);
        }
        for (String s : listLine) {
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
