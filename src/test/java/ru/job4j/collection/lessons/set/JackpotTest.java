package ru.job4j.collection.lessons.set;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JackpotTest {
    @Test
    public void checkYourWinTrue() {
        String[] strings = {"@", "@", "@", "@"};
        boolean win = Jackpot.checkYourWin(strings);
        assertTrue(win);
    }

    @Test
    public void checkYourWinFalse() {
        String[] strings = {"&&", "&", "&&&", "&&&&"};
        boolean win = Jackpot.checkYourWin(strings);
        assertFalse(win);
    }
}