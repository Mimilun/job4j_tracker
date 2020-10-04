package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                /*            } else if (...) { */
                /*             Добавить остальные действия системы по меню. */
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                showItems(items);
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.println("Enter ID of item: ");
                int id = Integer.valueOf(scanner.nextLine());
                String name = String.valueOf(scanner.nextLine());
                Item item = new Item(name);
                boolean res = tracker.replace(id, item);
                if (res) {
                    System.out.println("Successfully!");
                } else {
                    System.out.println("Error");
                }

            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.println("Enter ID of item: ");
                int id = Integer.valueOf(scanner.nextLine());
                boolean res = tracker.delete(id);
                if (res) {
                    System.out.println("Delete Item " + id + " successfully!");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = new Item();
                if ((item = tracker.findById(id)) == null) {
                    System.out.println("Заявка с таким id не найдена");
                } else {
                    System.out.println("ID: " + item.getId() + " = name:" + item.getName());
                }
            } else if (select == 5) {
                System.out.println("Find items by name");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length == 0) {
                    System.out.println("Заявки с таким именем не найдены");
                } else {
                    showItems(items);
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        /* добавить остальные пункты меню. */
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    private void showItems(Item[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.println("ID: " + items[i].getId() + " = name:" + items[i].getName());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}