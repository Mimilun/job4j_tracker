package ru.job4j.singleton;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;


public class Tracker1Test {

    @Test
    public void Tracker1EnumTest () {
        Tracker1 tracker = Tracker1.INSTANCE;
        Tracker tr = tracker.getTracker();
        Item item = new Item("Own");
        tr.add(item);
        Tracker tr2 = Tracker1.INSTANCE.getTracker();
        assertThat(tr2.indexOf(1), is(0));
    }

    @Test
    public void Tracker2Test () {
        Tracker2 tracker = Tracker2.getInstance();
        tracker.setRetr(5);
        Tracker2 tracker2 = Tracker2.getInstance();
        assertThat(tracker2.getRetr(), is(5));
    }

    @Test
    public void Tracker3Test () {
        Tracker3 tracker = Tracker3.getInstance();
        tracker.setRetr(5);
        Tracker3 tracker2 = Tracker3.getInstance();
        assertThat(tracker2.getRetr(), is(5));
    }

    @Test
    public void Tracker4Test () {
        Tracker4 tracker = Tracker4.getInstance();
        tracker.setRetr(5);
        Tracker4 tracker2 = Tracker4.getInstance();
        assertThat(tracker2.getRetr(), is(5));
    }
}