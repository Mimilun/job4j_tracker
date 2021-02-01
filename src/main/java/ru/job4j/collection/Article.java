package ru.job4j.collection;

import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {

        origin = origin.replaceAll("\\p{Punct}", "");
        line = line.replaceAll("\\p{Punct}", "");

        String[] arrOr = origin.split(" ");
        String[] arrLine = line.split(" ");

        Map<String, Integer> mapOr = new HashMap<>();

        for (String s : arrOr) {
            if (mapOr.containsKey(s)) {
                mapOr.put(s, mapOr.get(s) + 1);
            } else {
                mapOr.put(s, 1);
            }

        }

        System.out.println(mapOr);

        boolean res = true;
        for (String s : arrLine) {
            try {
                if (mapOr.get(s) > 1) {

                    mapOr.put(s, mapOr.get(s) - 1);

                } else {
                    mapOr.remove(s);
                }
            } catch (NullPointerException npe) {
                res = false;
                break;
            }
        }
        return res;
    }
}

