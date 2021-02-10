package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MapStudentTest {

    @Test
    public void testToMapStudent() {
        Student st1 = new Student(78, "Ivanov");
        Student st2 = new Student(73, "Petrov");
        Student st3 = new Student(82, "Sidorov");
        Student st4 = new Student(77, "Pupkin");
        Student st5 = new Student(69, "Petrova");

        List<Student> listStudent = new ArrayList<>(Arrays.asList(
                st1, st2, st3, st4, st5));
        Map<String, Student> expect = new LinkedHashMap<String, Student>();
        expect.put("Ivanov", st1);
        expect.put("Petrov", st2);
        expect.put("Sidorov", st3);
        expect.put("Pupkin", st4);
        expect.put("Petrova", st5);

        Map<String, Student> res = MapStudent.toMapStudent(listStudent);

        Assert.assertEquals(expect, res);
    }
}