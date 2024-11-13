package com.pluralsight;

import java.util.HashMap;
import java.util.Map;


// The toppingMenu and premiumToppingPrices HashMaps provide a smart way to store and retrieve information about
// toppings without the need for cluttering  getter setter methods.
//Example: Quickly determine if a topping is regular or premium, and fetch its price based on the size.


// Class representing a topping on the sandwich
public class Topping {
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
        toppingMenu.put("American Cheese", "Premium");
        toppingMenu.put("Provolone Cheese", "Premium");
        toppingMenu.put("Cheddar Cheese", "Premium");
        toppingMenu.put("Swiss Cheese", "Premium");
        toppingMenu.put("Avocado", "Premium");

        // Initialize sauces/condiments (included in price)
        toppingMenu.put("Mayo", "Regular");
        toppingMenu.put("Garlic Aioli", "Regular");
        toppingMenu.put("Thousand Island", "Regular");
        toppingMenu.put("Mustard", "Regular");
        toppingMenu.put("Ranch", "Regular");
        toppingMenu.put("Vinaigrette", "Regular");
        toppingMenu.put("Ketchup", "Regular");
        toppingMenu.put("Oil and Vinegar", "Regular");


        // Prices for premium toppings by size
        premiumToppingPrices.put("Steak", 1.00);    // Small 4": $1.00, Medium 8": $2.00, Large 12": $3.00
        premiumToppingPrices.put("Ham", 1.00);
        premiumToppingPrices.put("Salami", 1.00);
        premiumToppingPrices.put("Roast Beef", 1.00);
        premiumToppingPrices.put("Chicken", 1.00);
        premiumToppingPrices.put("Bacon", 1.00);
        premiumToppingPrices.put("American Cheese", 0.75);  // Small: $0.75, Medium: $1.50, Large: $2.25
        premiumToppingPrices.put("Provolone Cheese", 0.75);
        premiumToppingPrices.put("Cheddar Cheese", 0.75);
        premiumToppingPrices.put("Swiss Cheese", 0.75);
        premiumToppingPrices.put("Avocado", 1.00);
    }

    Topping(String name) { this.name = name;
    // Get the type of topping (Regular or Premium) from the menu
        this.type = toppingMenu.getOrDefault(name, "Regular");
    }

    double calculatePrice(String size) {
        double price = 0;
        if (type.equals("Premium")) {
            // Calculate price for premium toppings based on sandwich size
            double pricePerUnit = premiumToppingPrices.get(name);
            switch (size) {
                case "4": // if size is 4, it is price per unit
                    price = pricePerUnit;
                    break;
                case "8": // for 8 inch, price of topping set above is doubled
                    price = 2 * pricePerUnit;
                    break;
                case "12": // if 12 inch, price stated above is tripled
                    price = 3 * pricePerUnit;
                    break;

        }

        }

        return price;
    }


}
