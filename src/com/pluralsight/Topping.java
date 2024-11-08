package com.pluralsight;

import java.util.HashMap;
import java.util.Map;

class Topping {
    String name;
    String type;
    int quantity;

    // Menu of toppings
    static Map<String, String> toppingMenu = new HashMap<>();
    static Map<String, Double> premiumToppingPrices = new HashMap<>();

    static {
        // Initialize regular toppings
        toppingMenu.put("Lettuce", "Regular");
        toppingMenu.put("Tomato", "Regular");
        toppingMenu.put("Pickles", "Regular");
        toppingMenu.put("Peppers", "Regular");
        toppingMenu.put("Onions", "Regular");

        // Initialize premium toppings
        toppingMenu.put("americanCheese", "Premium");
        toppingMenu.put("Avocado", "Premium");

        // Prices for premium toppings
        premiumToppingPrices.put("Cheese", 1.00);
        premiumToppingPrices.put("Avocado", 1.00);
    }

    Topping(String name, int quantity) {
        this.name = name;
        this.type = toppingMenu.getOrDefault(name, "Regular");
        this.quantity = quantity;
    }

    double calculatePrice(String size) {
        double basePrice = 0;
        if (type.equals("Premium")) {
            basePrice = premiumToppingPrices.get(name) * quantity;
        }
        return basePrice;
    }
}
