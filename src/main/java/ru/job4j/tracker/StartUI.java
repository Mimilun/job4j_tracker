package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = Integer.valueOf(input.askStr("Enter ID of item: "));
        String name = String.valueOf(input.askStr("Enter name: "));
        Item item = new Item(name);
        boolean res = tracker.replace(id, item);
        if (res) {
            System.out.println("Successfully!");
        } else {
            System.out.println("Error");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = Integer.valueOf(input.askStr("Enter ID of item: "));
        boolean res = tracker.delete(id);
        if (res) {
            System.out.println("Delete Item " + id + " successfully!");
        } else {
            System.out.println("Error");
        }
    }

    public static void findByIdItem(Input input, Tracker tracker){
        System.out.println("=== Find item by Id ===");
        int id = Integer.valueOf(input.askStr("Enter ID of item: "));
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка с таким id не найдена");
        } else {
            System.out.println("ID: " + item.getId() + " = name:" + item.getName());
        }
    }

    public static void findByNameItem(Input input, Tracker tracker) {
        System.out.println("Find items by name");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("Заявки с таким именем не найдены");
        } else {
            StartUI.showItems(tracker); //вопрос в коментарии
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));

            if (select == 0) {
                StartUI.createItem(input, tracker);

            } else if (select == 1) {
                StartUI.showItems(tracker);

            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);

            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);

            } else if (select == 4) {
                StartUI.findByIdItem(input, tracker);

            } else if (select == 5) {
                StartUI.findByNameItem(input, tracker);

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

    private static void showItems(Tracker tracker) {
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println("ID: " + items[i].getId() + " = name:" + items[i].getName());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}