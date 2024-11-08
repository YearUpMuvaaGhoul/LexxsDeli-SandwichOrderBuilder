package com.pluralsight;

class Chips extends Item {
    Chips(String name) {
        super(name);
    }

    @Override
    double calculatePrice() {
        return 1.50;
    }
}
