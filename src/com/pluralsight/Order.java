package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

class Order {
    List<Item> items = new ArrayList<>();
    double totalPrice;

    // Method to add an item to the order
    void addItem(Item item) {
        items.add(item);
    }

    // Method to calculate the total price of the order
    double calculateTotal() {
        totalPrice = 0;
        for (Item item : items) {
            if (item instanceof Sandwich) {
                Sandwich sandwich = (Sandwich) item;
                totalPrice += sandwich.calculateTotalCost();
            } else {
                totalPrice += item.calculatePrice();
            }
        }
        return totalPrice;
    }
}
