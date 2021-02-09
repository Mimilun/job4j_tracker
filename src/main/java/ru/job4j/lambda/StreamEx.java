package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-3, 5, 4, -7, 2, -6));

        List<Integer> listOut = list.stream()
                .filter(x -> x >= 0)
                .collect(Collectors.toList());
    }
}
