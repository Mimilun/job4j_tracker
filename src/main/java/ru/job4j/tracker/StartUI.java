package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
//        DateTimeFormatter outDateFormat = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
//        String dataTimeFomat = item.getCreated().format(outDateFormat);
//        System.out.println(dataTimeFomat);

        Item item = new Item();
        Tracker objTracker = new Tracker();
        objTracker.add(item);

        System.out.println(objTracker.findById(1));
    }
}
