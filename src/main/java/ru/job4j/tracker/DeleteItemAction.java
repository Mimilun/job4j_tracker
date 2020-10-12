package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {

    @Override
    public String name() {

        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter ID of item: ");
        boolean res = tracker.delete(id);
        if (res) {
            System.out.println("Delete Item " + id + " successfully!");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
