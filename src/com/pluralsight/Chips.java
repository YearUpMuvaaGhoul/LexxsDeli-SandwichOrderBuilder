package com.pluralsight;

// Class representing chips, extending Item
class Chips extends Item {
    String type; // Type of chips

    Chips(String type, double chipsPrice) {
        super(type);
        this.type = type;
    }

    @Override
    double calculatePrice() {
        return 1.50; // Fixed price for all chips
    }
}
