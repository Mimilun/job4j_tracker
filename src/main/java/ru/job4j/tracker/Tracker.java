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

        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] itemByName = new Item[this.size];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
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
        boolean rls = index != -1;
        if (rls) {
            items[index] = item;
            items[index].setId(id);
        }
        return rls;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rls = index != - 1;
        if (rls) {
            System.arraycopy(items, index + 1, items, index, size - index);
            items[--size] = null;
        }
        return rls;
    }

}