package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProfilesTest {

    @Test
    public void collectTest() {
        Address adr1 = new Address("Minsk", "Pushkina", 23, 12);
        Address adr2 = new Address("Pinsk", "Mojsha", 34, 8);
        Address adr3 = new Address("Lida", "Kolosa", 12, 4);
        Address adr4 = new Address("Minsk", "Pushkina", 23, 12);
        Address adr5 = new Address("Polotsk", "Gogolja", 47, 3);
        Address adr6 = new Address("Lida", "Kolosa", 12, 4);

        List<Profile> listProfile = List.of(new Profile(adr1), new Profile(adr2), new Profile(adr3),
                new Profile(adr4), new Profile(adr5), new Profile(adr6));
        Profiles profiles = new Profiles();
        List<Address> expected = List.of(adr3, adr1, adr2, adr5);
        List<Address> res = profiles.collect(listProfile);

        Assert.assertEquals(expected, res);
    }
}