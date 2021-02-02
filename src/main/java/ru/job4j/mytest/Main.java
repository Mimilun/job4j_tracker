package ru.job4j.mytest;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> listAnimal = new ArrayList<>();

        listAnimal.add(new Animal(1));
        listAnimal.add(new Animal(2));
        listAnimal.add(new Animal(3));

        List<Dog> listDog = new ArrayList<>();

        listDog.add(new Dog());
        listDog.add(new Dog());
        listDog.add(new Dog());

        test(listAnimal);
        test(listDog);

    }

    public static void test(List<? extends Animal> l) {
        for (Animal elem : l) {
            elem.sound();
        }
    }
}
