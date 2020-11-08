package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {

    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {

        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() == 0) {
            out.println("Заявки с таким именем не найдены");
        } else {
            for (int i = 0; i < items.size(); i++) {
                out.println("ID: " + items.get(i).getId() + " = name:" + items.get(i).getName());
            }
        }
        return true;
    }
}
