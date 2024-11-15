package com.pluralsight.BaseClasses;

import com.pluralsight.BaseClasses.*;
import com.pluralsight.SandwichBuilder.Sandwich;
import com.pluralsight.Utils.*;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public List<Item> items = new ArrayList<>();
    double totalPrice;

    // Method to add an item to the order
    public void addItem(Item item) {
        items.add(item);
    }

    // Method to calculate the total price of the order
    public double calculateTotal() {
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
