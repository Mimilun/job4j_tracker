package ru.job4j.patterns.builder;

public class Smartphone {

    private String nameModel;
    private int year;
    private int sizeDiagonal;
    private String serialProcessor;
    private int ram;
    private int capacityBattery;
    private String color;

    static class Builder {
        private String nameModel;
        private int year;
        private int sizeDiagonal;
        private String serialProcessor;
        private int ram;
        private int capacityBattery;
        private String color;

        public Builder buildNameModel(String nameModel) {
            this.nameModel = nameModel;
            return this;
        }

        public Builder buildYear(int year) {
            this.year = year;
            return this;
        }

        public Builder buildSizeDiagonal(int sizeDiagonal) {
            this.sizeDiagonal = sizeDiagonal;
            return this;
        }

        public Builder buildSerialProcessor(String serialProcessor) {
            this.serialProcessor = serialProcessor;
            return this;
        }

        public Builder buildRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder buildCapacityBattery(int capacityBattery) {
            this.capacityBattery = capacityBattery;
            return this;
        }

        public Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        public Smartphone builder() {
            Smartphone smartphone = new Smartphone();
            smartphone.nameModel = nameModel;
            smartphone.year = year;
            smartphone.sizeDiagonal = sizeDiagonal;
            smartphone.serialProcessor = serialProcessor;
            smartphone.ram = ram;
            smartphone.capacityBattery = capacityBattery;
            smartphone.color = color;
            return smartphone;
        }
    }

    @Override
    public String toString() {
        return "BuilderEx{"
                + "nameModel='" + nameModel + '\''
                + ", year=" + year
                + ", sizeDiagonal=" + sizeDiagonal
                + ", serialProcessor='" + serialProcessor + '\''
                + ", ram=" + ram
                + ", capacityBattery=" + capacityBattery
                + ", color='" + color + '\'' + '}';
    }
}
