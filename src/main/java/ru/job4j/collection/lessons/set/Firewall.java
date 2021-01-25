package ru.job4j.collection.lessons.set;

import java.util.Set;

public class Firewall {
    public static String checkName(String s, Set<String> words) {

        String[] strArr = s.split(" ");
        for (String world : strArr) {
            if (words.contains(world)) {
                return "Выберите другую статью...";
            }
        }
        return "Вы сделали правильный выбор!";
    }
}
