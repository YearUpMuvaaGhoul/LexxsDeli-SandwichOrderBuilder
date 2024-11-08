package com.pluralsight;

import java.util.HashMap;
import java.util.Map;

// Class representing a topping on the sandwich
class Topping {
    String name;
    String type;

    // Menu of toppings with their type (Regular or Premium)
    static Map<String, String> toppingMenu = new HashMap<>();

    // Prices for premium toppings
    static Map<String, Double> premiumToppingPrices = new HashMap<>();

    static {
        // Initialize regular toppings
        toppingMenu.put("Lettuce", "Regular");
        toppingMenu.put("Tomato", "Regular");
        toppingMenu.put("Pickles", "Regular");
        toppingMenu.put("Peppers", "Regular");
        toppingMenu.put("Onions", "Regular");
        toppingMenu.put("Jalapenos", "Regular");
        toppingMenu.put("Cucumbers", "Regular");
        toppingMenu.put("Guacamole", "Regular");
        toppingMenu.put("Mushrooms", "Regular");

        // Initialize premium toppings
        toppingMenu.put("Steak", "Premium");
        toppingMenu.put("Ham", "Premium");
        toppingMenu.put("Salami", "Premium");
        toppingMenu.put("Roast Beef", "Premium");
        toppingMenu.put("Chicken", "Premium");
        toppingMenu.put("Bacon", "Premium");
        toppingMenu.put("American", "Premium");
        toppingMenu.put("Provolone", "Premium");
        toppingMenu.put("Cheddar", "Premium");
        toppingMenu.put("Swiss", "Premium");
        toppingMenu.put("Avocado", "Premium");

        // Prices for premium toppings by size
        premiumToppingPrices.put("Steak", 1.00);    // Small: $1.00, Medium: $2.00, Large: $3.00
        premiumToppingPrices.put("Ham", 1.00);
        premiumToppingPrices.put("Salami", 1.00);
        premiumToppingPrices.put("Roast Beef", 1.00);
        premiumToppingPrices.put("Chicken", 1.00);
        premiumToppingPrices.put("Bacon", 1.00);
        premiumToppingPrices.put("American", 0.75);  // Small: $0.75, Medium: $1.50, Large: $2.25
        premiumToppingPrices.put("Provolone", 0.75);
        premiumToppingPrices.put("Cheddar", 0.75);
        premiumToppingPrices.put("Swiss", 0.75);
        premiumToppingPrices.put("Avocado", 1.00);
    }

    Topping(String name) {
        this.name = name;
        // Determine the type of topping (Regular or Premium) from the menu
        this.type = toppingMenu.getOrDefault(name, "Regular");
    }

    double calculatePrice(String size) {
        // If the topping is premium, calculate price based on the size of the sandwich
        if (type.equals("Premium")) {
            double pricePerUnit = premiumToppingPrices.get(name);
            switch (size) {
                case "4":
                    return pricePerUnit;
                case "8":
                    return 2 * pricePerUnit;
                case "12":
                    return 3 * pricePerUnit;
                default:
                    return 0;
            }
        }
        // If the topping is extra cheese, calculate price based on the size of the sandwich
        else if (name.equals("Extra Cheese")) {
            switch (size) {
                case "4":
                    return 0.30;
                case "8":
                    return 0.60;
                case "12":
                    return 0.90;
                default:
                    return 0;
            }
        }
        // Regular toppings are free
        return 0;
    }
}
