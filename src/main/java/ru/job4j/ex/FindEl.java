package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        /* for-each */
        int index = 0;
        for (String val : value) {
            if (val.equals(key)) {
                rsl = index;
                break;
            }
            index++;
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Элемент не найден");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] str = {"qwe", "asd", "rty", "wsx"};
        try {
            int findIndex = indexOf(str, "rt");
            System.out.println(findIndex);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
