package ru.job4j.condition;

public class LeapYear {
    public static boolean checkYear(int year) {
        return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
    }
}
