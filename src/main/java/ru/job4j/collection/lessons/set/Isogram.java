package ru.job4j.collection.lessons.set;

import java.util.HashSet;
import java.util.Set;

public class Isogram {
    public static boolean checkString(String s) {
        Set<Character> set = new HashSet<>();
        for (Character ch : s.toCharArray()) {
            set.add(ch);
        }
        return set.size() == s.length();
    }
}
