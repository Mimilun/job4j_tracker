package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public void add(Item item) {
        item.setId(ids++);
        items.add(item);
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> itemByName = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemByName.add(item);
            }
        }
        return itemByName;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public int indexOf(int id) {
        int index = -1;
        for (Item item : items) {
            index++;
            if (item.getId() == id) {
                break;
            }
        }
        return index;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rls = index != -1;
        if (rls) {
            items.set(index, item);
            items.get(index).setId(id);
        }
        return rls;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        return items.remove(items.get(index));
    }

}