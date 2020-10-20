//SingleTon private static final class. Lazy loading.

package ru.job4j.singleton;

public class Tracker4 {

    private int retr = 0;

    private Tracker4() {
    }

    public static Tracker4 getInstance() {
        return Holder.INSTANCE;
    }

    public int getRetr() {
        return retr;
    }

    public void setRetr(int x) {
        retr = x;
    }

    private static final class Holder {
        private static final Tracker4 INSTANCE = new Tracker4();
    }
}
