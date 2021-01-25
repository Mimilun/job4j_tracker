package ru.job4j.collection.lessons.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Jackpot {

    public static boolean checkYourWin(String[] combination) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, combination);
        return set.size() == 1;
    }
}
