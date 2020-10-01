package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] allItems = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                allItems[size++] = items[i];
            }
        }
        return allItems = Arrays.copyOf(allItems, size);
    }

    public Item[] findByName(String key) {
        Item[] itemByName = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(key)) {
                itemByName[size++] = items[i];
            }
        }
        return itemByName = Arrays.copyOf(itemByName, size);
    }


    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public int indexOf(int id) {
        int rls = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                rls = i;
                break;
            }
        }
        return rls;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rls = false;
        if (index != -1) {
            items[index] = item;
            items[index].setId(id);
            rls = true;
        }
        return rls;
    }

}