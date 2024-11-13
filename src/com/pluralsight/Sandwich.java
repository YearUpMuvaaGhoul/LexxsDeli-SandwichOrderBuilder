package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

// Class representing a sandwich, extending Item

class Sandwich extends Item {
    String size; // Size of the sandwich (e.g., 4, 8, 12 inches)
    Bread bread; // Type of bread
    List<Topping> toppings = new ArrayList<>(); // List of toppings
    boolean isToasted; // Whether the sandwich is toasted
    int extraCheese; // Extra cheese option
    int extraMeat; // Extra meat option

    // Constructor to initialize a sandwich
    Sandwich(String name, String size, Bread bread) {
        super(name); // Call the constructor of the Item class
        this.size = size;
        this.bread = bread;
    }

    // Method to add a topping to the sandwich
    void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Method to set the amount of extra cheese
    void setExtraCheese(int extraCheese) {
        this.extraCheese = extraCheese;
    }

    // Method to set the amount of extra meat
    void setExtraMeat(int extraMeat) {
        this.extraMeat = extraMeat;
    }

    // Method to calculate the base price of the sandwich based on its size
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
        return basePrice;
    }

    // Method to calculate the price of extra cheese
    double calculateExtraCheesePrice() {
        double extraCheesePrice = 0;
        switch (size) {
            case "4":
                extraCheesePrice = extraCheese * 0.30;
                break;
            case "8":
                extraCheesePrice = extraCheese * 0.60;
                break;
            case "12":
                extraCheesePrice = extraCheese * 0.90;
                break;
        }
        return extraCheesePrice;
    }

    // Method to calculate the price of extra meat
    double calculateExtraMeatPrice() {
        double extraMeatPrice = 0;
        switch (size) {
            case "4":
                extraMeatPrice = extraMeat * 0.50;
                break;
            case "8":
                extraMeatPrice = extraMeat * 1.00;
                break;
            case "12":
                extraMeatPrice = extraMeat * 1.50;
                break;
        }
        return extraMeatPrice;
    }

    // Method to calculate the total cost of the sandwich
    double calculateTotalCost() {
        double basePrice = calculatePrice(); // Base price of the sandwich

        // Loop through all the toppings and add their prices to the topping price
        double toppingPrice = 0;
        for (Topping topping : toppings) {
            toppingPrice += topping.calculatePrice(size);
        }

        double extraCheesePrice = calculateExtraCheesePrice();
        double extraMeatPrice = calculateExtraMeatPrice();

        // Return the total price including base price, topping price, extra cheese price, and extra meat price
        return basePrice + toppingPrice + extraCheesePrice + extraMeatPrice;
    }
}

