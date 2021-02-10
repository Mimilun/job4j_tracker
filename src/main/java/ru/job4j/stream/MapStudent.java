package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStudent {

    private Student st1 = new Student(78, "Ivanov");
    private Student st2 = new Student(73, "Petrov");
    private Student st3 = new Student(82, "Sidorov");
    private Student st4 = new Student(77, "Pupkin");
    private Student st5 = new Student(69, "Petrova");

    private List<Student> listStudent = new ArrayList<>(Arrays.asList(
            st1, st2, st3, st4, st5));

    public static Map<String, Student> toMapStudent(List<Student> list) {
        return list.stream()
                .collect(Collectors.toMap(Student::getSurname, e -> e));
    }
}
