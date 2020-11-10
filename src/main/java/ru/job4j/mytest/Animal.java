package ru.job4j.mytest;

public class Animal {
    private int id;

    public Animal() {
    }

    public Animal(int id) {
       this.id = id;
    }

    public void sound() {
        System.out.println("Animal " + id);
    }
}
