package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

// Class representing a sandwich, extending Item
class Sandwich extends Item {
    String size; // Size of the sandwich (4", 8", 12")
    Bread bread; // Bread type
    List<Topping> toppings = new ArrayList<>(); // List of toppings
    boolean isToasted; // Whether the sandwich is toasted or not

    Sandwich(String name, String size, Bread bread) {
        super(name);
        this.size = size;
        this.bread = bread;
    }

    // Add a topping to the sandwich
    void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Calculate the price of the sandwich based on size and toppings
    @Override
    double calculatePrice() {
        double basePrice;
        switch (size) {
            case "4":
                basePrice = 5.50;
                break;
            case "8":
                basePrice = 7.00;
                break;
            case "12":
                basePrice = 8.50;
                break;
            default:
                basePrice = 0;
        }
        for (Topping topping : toppings) {
            basePrice += topping.calculatePrice(size);
        }
        return basePrice;
    }
}
