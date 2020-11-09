package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {

    private final Output out;

    public DeleteItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {

        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter ID of item: ");
        Object res = tracker.delete(id);
        if (res != null) {
            out.println("Delete Item " + id + " successfully!");
        } else {
            out.println("Error");
        }
        return true;
    }
}
