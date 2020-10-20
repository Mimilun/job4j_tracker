package ru.job4j.singleton;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;


public class Tracker1Test {

    @Test
    public void Tracker1EnumTest () {
        Tracker1 tracker = Tracker1.INSTANCE;
        tracker.setRetr(5);
        Tracker1 tracker2 = Tracker1.INSTANCE;
        assertThat(tracker2.getRetr(), is(5));
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