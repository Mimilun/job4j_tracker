package ru.job4j.tracker;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

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
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Show all items ===" + System.lineSeparator() +
                        "1. === Exit Program ===" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Show all items ===" + System.lineSeparator() +
                        "1. === Exit Program ===" + System.lineSeparator()
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
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu.\r\n0. === Find items by name ====\r\n" +
                "1. === Exit Program ===\r\nЗаявки с таким именем не найдены\r\n" +
                "Menu.\r\n0. === Find items by name ====\r\n" +
                "1. === Exit Program ===\r\n")
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
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu.\r\n0. === Find item by Id ===\r\n" +
                "1. === Exit Program ===\r\n" +
                "ID: 1 = name:Find ID item\r\n" +
                "Menu.\r\n0. === Find item by Id ===\r\n" +
                "1. === Exit Program ===\r\n"));
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
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction()
        };
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
        UserAction[] actions = {
                new DeleteItemAction(out),
                new ExitAction()
        };
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
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Exit Program ===" + System.lineSeparator()
                )
        );
    }


    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] { "11", "0"/* Пункты меню: неверный, верный.*/ }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. === Exit Program ===%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. === Exit Program ===%n"
                )
        ));
    }
}