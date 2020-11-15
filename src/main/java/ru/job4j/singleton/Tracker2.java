//SingleTon static field. Lazy loading.

package ru.job4j.singleton;

public class Tracker2 {

    private static Tracker2 instance = null;
    private int retr = 0;

    private Tracker2() {

    }

    public static Tracker2 getInstance() {
        if (instance == null) {
            instance = new Tracker2();
        }
        return instance;
    }

    public int getRetr() {
        return retr;
    }

    public void setRetr(int x) {
        retr = x;
    }
}
