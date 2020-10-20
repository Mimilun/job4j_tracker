//SingleTon Enum. Eager loading.

package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public enum Tracker1 {

    INSTANCE;

    private Tracker track = new Tracker();

    public Tracker getTracker() {
        return track;
    }
}
