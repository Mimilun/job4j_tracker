package ru.job4j.condition;

public class WeeklySalary {
    public static int calculate(int[] hours) {
        int rsl = 0;
        for (int i = 0; i < hours.length; i++) {
            if (i < 5) {
                if (hours[i] > 8) {
                    rsl += 8 * 10 + (hours[i] - 8) * 15;
                } else {
                    rsl += hours[i] * 10;
                }
            } else {
                if (hours[i] > 8) {
                    rsl += (8 * 10 + (hours[i] - 8) * 15) * 2;
                } else {
                    rsl += hours[i] * 10 * 2;
                }
            }
        }
        return rsl;
    }
}
