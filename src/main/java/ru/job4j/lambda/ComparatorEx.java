package ru.job4j.lambda;

import java.util.Comparator;

public class ComparatorEx {
    public static void main(String[] args) {

        Comparator<Attachment> comparator = (left, right) -> {
            System.out.println("compare - " + left.getSize() + " : " + right.getSize());
            return right.getSize() - left.getSize();
        };
    }
}
