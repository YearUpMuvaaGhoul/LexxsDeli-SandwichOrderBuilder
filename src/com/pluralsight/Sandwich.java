package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

class Sandwich extends Item {
    String size;
    Bread bread;
    List<Topping> toppings = new ArrayList<>();
    boolean isToasted;

    Sandwich(String name, String size, Bread bread) {
        super(name);
        this.size = size;
        this.bread = bread;
    }

    void addTopping(Topping topping) {
        toppings.add(topping);
    }

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
