package ru.job4j.patterns.builder;

public class CreateSmartphones {

    public static void main(String[] args) {
        Smartphone smart1 = new Smartphone.Builder().buildNameModel("ARTiNL")
                .buildYear(2021)
                .buildSizeDiagonal(6)
                .buildSerialProcessor("Intel I12 P3")
                .buildRam(128)
                .buildCapacityBattery(6000)
                .buildColor("White")
                .builder();

        System.out.println(smart1);
    }

}
