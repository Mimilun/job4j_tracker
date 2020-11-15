//SingleTon static final field. Eager loading.

package ru.job4j.singleton;

public class Tracker3 {

    public static final Tracker3 INSTANCE = new Tracker3();
    private int retr = 0;

    private Tracker3() {

    }

    public static Tracker3 getInstance() {
        return INSTANCE;
    }

    public int getRetr() {
        return retr;
    }

    public void setRetr(int x) {
        retr = x;
    }
}
