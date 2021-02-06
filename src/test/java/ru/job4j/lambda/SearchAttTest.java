package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchAttTest {

    @Test
    public void filterSize() {
        List<Attachment> list = new ArrayList<>();
        Attachment at1 = new Attachment("How aplly", 80);
        Attachment at2 = new Attachment("I get to carry the bag, and I scare out the hares.", 20);
        Attachment at3 = new Attachment("Replace from adress", 120);
        Attachment at4 = new Attachment("— I'll tell the driver about your bag.", 90);
        Attachment at5 = new Attachment("Replace from adress", 310);
        list.add(at1);
        list.add(at2);
        list.add(at3);
        list.add(at4);
        list.add(at5);
        List<Attachment> expected = new ArrayList<>();
        expected.add(at3);
        expected.add(at5);
        List<Attachment> rsl = SearchAtt.filterSize(list, 100);
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void filterName() {
        List<Attachment> list = new ArrayList<>();
        Attachment at1 = new Attachment("How aplly", 80);
        Attachment at2 = new Attachment("I get to carry the bag, and I scare out the hares.", 20);
        Attachment at3 = new Attachment("Replace from adress", 120);
        Attachment at4 = new Attachment("— I'll tell the driver about your bag.", 90);
        Attachment at5 = new Attachment("Replace from adress", 310);
        list.add(at1);
        list.add(at2);
        list.add(at3);
        list.add(at4);
        list.add(at5);
        List<Attachment> expected = new ArrayList<>();
        expected.add(at2);
        expected.add(at4);
        List<Attachment> rsl = SearchAtt.filterName(list, "bag");
        Assert.assertEquals(expected, rsl);
    }
}