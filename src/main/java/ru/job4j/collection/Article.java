package ru.job4j.collection;

import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {

        List<String> listOr = new ArrayList<>(Arrays.asList(origin.split("[,.;:!? ]")));
        List<String> listLine = new ArrayList<>(Arrays.asList(line.split("[,.;:!? ]")));

        return listOr.containsAll(listLine);
    }
}
