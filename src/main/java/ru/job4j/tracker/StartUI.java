package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    private static Item item = new Item();

    public static void main(String[] args) {
//        DateTimeFormatter outDateFormat = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
//        String dataTimeFomat = item.getCreated().format(outDateFormat);
//        System.out.println(dataTimeFomat);

        System.out.println(item);
    }
}
