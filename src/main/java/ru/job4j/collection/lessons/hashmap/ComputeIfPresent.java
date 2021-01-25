package ru.job4j.collection.lessons.hashmap;

import java.util.Map;

public class ComputeIfPresent {
    public static Map<Integer, String> collectData(
            Map<Integer, String> name, Map<Integer, String> surname) {
        for (Integer key : surname.keySet()) {
            name.computeIfPresent(key, (a, b) -> b + " " + surname.get(key));
        }
        return name;
    }
}
