package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();

        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction());
        actions.add(new ExitAction());

        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction());

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + "\n"
                        + "0. === Show all items ===" + "\n"
                        + "1. === Exit Program ===" + "\n"
                        + "Menu." + "\n"
                        + "0. === Show all items ===" + "\n"
                        + "1. === Exit Program ===" + "\n"
                )
        );
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction());

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu.\n0. === Find items by name ====\n"
                + "1. === Exit Program ===\nЗаявки с таким именем не найдены\n"
                + "Menu.\n0. === Find items by name ====\n"
                + "1. === Exit Program ===\n")
        );
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = new Item("Find ID item");
        tracker.add(item);
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String strId = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[]{"0", strId, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction());

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu.\n0. === Find item by Id ===\n"
                + "1. === Exit Program ===\n"
                + "ID: 1 = name:Find ID item\n"
                + "Menu.\n0. === Find item by Id ===\n"
                + "1. === Exit Program ===\n"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = new Item("Replaced item");
        tracker.add(item);
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        String strId = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[]{"0", strId, replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new ExitAction());

        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = new Item("Deleted item");
        tracker.add(item);
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String strId = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[]{"0", strId, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteItemAction(out));
        actions.add(new ExitAction());

        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + "\n"
                        + "0. === Exit Program ===" + "\n"
                )
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"11", "0"/* Пункты меню: неверный, верный.*/}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.\n"
                                + "0. === Exit Program ===\n"
                                + "Wrong input, you can select: 0 .. 0\n"
                                + "Menu.\n"
                                + "0. === Exit Program ===\n"
                )
        ));
    }
}