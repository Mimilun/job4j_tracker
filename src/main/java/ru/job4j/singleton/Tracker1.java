//SingleTon Enum. Eager loading.

package ru.job4j.singleton;

public enum Tracker1 {

    INSTANCE;

    private int retr = 0;

    public void Tracker1 () {

    }
    public int getRetr() {
        return retr;
    }
    public void setRetr(int x) {
        retr = x;
    }
}
