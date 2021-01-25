package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String str : deps) {
            String start = "";
            for (String item : str.split("/")) {
                start = start + item;
                tmp.add(start);
                start = start + "/";
            }
        }
        List<String> rsl = new ArrayList<>(tmp);
//        sortAsc(rsl);
//        sortDesc(rsl);
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }

//    public static void main(String[] args) {
//        List<String> deps = new ArrayList<>(Arrays.asList("k2", "k1/sk1"));
//        System.out.println(fillGaps(deps));
//    }
}
