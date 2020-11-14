package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemSortTest {

    @Test
    public void sortByIdUp() {
        Tracker tracker = new Tracker();
        Item item = new Item("B");
        tracker.add(item);
        item = new Item("C");
        tracker.add(item);
        item = new Item("A");
        tracker.add(item);
        List<Item> items = tracker.findAll();
        items.sort(new SortByIdUp());

        String expect = "[Item: id=1, name='B', Item: id=2, name='C', Item: id=3, name='A']";
        String result = items.toString();
        assertThat(result, is(expect));
    }

    @Test
    public void sortByIdDown() {
        Tracker tracker = new Tracker();
        Item item = new Item("B");
        tracker.add(item);
        item = new Item("C");
        tracker.add(item);
        item = new Item("A");
        tracker.add(item);
        List<Item> items = tracker.findAll();
        items.sort(new SortByIdDown());

        String expect = "[Item: id=3, name='A', Item: id=2, name='C', Item: id=1, name='B']";
        String result = items.toString();
        assertThat(result, is(expect));
    }

    @Test
    public void sortByNameUp() {
        Tracker tracker = new Tracker();
        Item item = new Item("B");
        tracker.add(item);
        item = new Item("C");
        tracker.add(item);
        item = new Item("A");
        tracker.add(item);
        List<Item> items = tracker.findAll();
        items.sort(new SortByNameUp());

        String expect = "[Item: id=3, name='A', Item: id=1, name='B', Item: id=2, name='C']";
        String result = items.toString();
        assertThat(result, is(expect));
    }

    @Test
    public void sortByNameDown() {
        Tracker tracker = new Tracker();
        Item item = new Item("B");
        tracker.add(item);
        item = new Item("C");
        tracker.add(item);
        item = new Item("A");
        tracker.add(item);
        List<Item> items = tracker.findAll();
        items.sort(new SortByNameDown());

        String expect = "[Item: id=2, name='C', Item: id=1, name='B', Item: id=3, name='A']";
        String result = items.toString();
        assertThat(result, is(expect));
    }
}