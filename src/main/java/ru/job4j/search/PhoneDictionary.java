package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
//    public ArrayList<Person> find(String key) {
//        ArrayList<Person> result = new ArrayList<>();
//        for (Person elem : persons) {
//            if (elem.getAddress().contains(key)
//                    || elem.getName().contains(key)
//                    || elem.getPhone().contains(key)
//                    || elem.getSurname().contains(key)) {
//
//                result.add(elem);
//            }
//        }
//        return result;
//    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combineAddress = (x) -> x.getAddress().contains(key);
        Predicate<Person> combineName = (x) -> x.getName().contains(key);
        Predicate<Person> combinePhone = (x) -> x.getPhone().contains(key);
        Predicate<Person> combineSurname = (x) -> x.getSurname().contains(key);
        Predicate<Person> combine = combineAddress
                .or(combineName)
                .or(combinePhone)
                .or(combineSurname);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
