package ru.job4j.collection.lessons.set;

import org.junit.Assert;
import org.junit.Test;

public class PangramTest {
    @Test
    public void checkString() {
        String str = "Jackdaws love my big sphinx of quartz";
        boolean b = Pangram.checkString(str);
        Assert.assertTrue(b);
    }
    @Test
    public void checkStringFalse() {
        String str = "ackdaws love my big sphinx of quartz";
        boolean b = Pangram.checkString(str);
        Assert.assertFalse(b);
    }
}