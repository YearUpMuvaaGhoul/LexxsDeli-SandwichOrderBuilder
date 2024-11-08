package com.pluralsight;

// Class representing a drink, extending Item
class Drink extends Item {
    String size; // Size of the drink (Small, Medium, Large)
    String type; // Type of the drink

    Drink(String type, String size) {
        super(type + " with pebble ice");
        this.size = size;
        this.type = type;
    }

    @Override
    double calculatePrice() {
        // Fixed prices based on the size of the drink
        switch (size.toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                return 0;
        }
    }
}

