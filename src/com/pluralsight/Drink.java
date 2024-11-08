package com.pluralsight;

class Drink extends Item {
    String size;

    Drink(String name, String size) {
        super(name);
        this.size = size;
    }

    @Override
    double calculatePrice() {
        return (size.equals("Small")) ? 2.00 : (size.equals("Medium")) ? 2.50 : 3.00;
    }
}
