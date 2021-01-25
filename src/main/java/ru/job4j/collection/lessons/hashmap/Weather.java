package ru.job4j.collection.lessons.hashmap;

import java.util.*;

public class Weather {
    public static List<Info> editData(List<Info> list) {
        List<Info> rsl = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int fall = 0;
        for (Info el : list) {
            fall = el.getRainfall();
            if (map.containsKey(el.getCity())) {
                fall = map.get(el.getCity()) + el.getRainfall();
            }
            map.put(el.getCity(), fall);
        }

        for (Map.Entry<String, Integer> el : map.entrySet()) {
            rsl.add(new Info(el.getKey(), el.getValue()));
        }
        return rsl;
    }

    public static class Info {
        private String city;

        private int rainfall;

        public Info(String city, int rainfall) {
            this.city = city;
            this.rainfall = rainfall;
        }

        public String getCity() {
            return city;
        }

        public int getRainfall() {
            return rainfall;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return rainfall == info.rainfall
                    && Objects.equals(city, info.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, rainfall);
        }

        @Override
        public String toString() {
            return "{city= " + city + '\''
                    + " - rainfall=" + rainfall + "}";
        }
    }
}
