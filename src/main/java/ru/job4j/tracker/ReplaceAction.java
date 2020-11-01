package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {

        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter ID of item: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        boolean res = tracker.replace(id, item);
        if (res) {
            out.println("Successfully!");
        } else {
            out.println("Error");
        }
        return true;
    }
}
