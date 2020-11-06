package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person elem : persons) {
            if (elem.getAddress().contains(key)) {
                result.add(elem);
                continue;
            }
            if (elem.getName().contains(key)) {
                result.add(elem);
                continue;
            }
            if (elem.getPhone().contains(key)) {
                result.add(elem);
                continue;
            }
            if (elem.getSurname().contains(key)) {
                result.add(elem);
            }
        }
        return result;
    }
}
