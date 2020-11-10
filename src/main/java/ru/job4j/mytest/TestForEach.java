package ru.job4j.mytest;

import java.util.*;

public class TestForEach {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>(Arrays.asList("q", "w", "e", "r", "t"));
        l.forEach(System.out::print);
        Collections.sort(l);
        System.out.println();
        l.forEach(System.out::print);
        System.out.println();

        List<Integer> lInt = new ArrayList<>(Arrays.asList(5, 2, 3, 4, 1));
        lInt.forEach(System.out::print);

        //Compar intCompar = new Compar();
        //Collections.sort(lInt, intCompar); // или
        //Collections.sort(lInt, new Compar()); // или
        //lInt.sort(intCompar); // или
        //lInt.sort(new Compar());

        Collections.sort(lInt, new Comparator<Integer>() { // анонимный класс
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println();
        lInt.forEach(System.out::print);

    }

//    static class Compar implements Comparator<Integer> {
//
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return o1 - o2;
//        }
//    }
}
