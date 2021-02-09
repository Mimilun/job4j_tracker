package ru.job4j.stream;

public class Profile {

    private Address address;

    public Address getAddress() {
        return address;
    }
}

class Address {

    private String city;
    private String street;
    private int home;
    private int apartment;

}

