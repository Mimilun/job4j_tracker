package ru.job4j.collection.lessons.set;

import java.util.HashSet;
import java.util.Set;

public class Pangram {
    public static boolean checkString(String s) {
        Set<Character> pangram = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                pangram.add(ch);
            }
        }
        return pangram.size() == 26;
    }
}
