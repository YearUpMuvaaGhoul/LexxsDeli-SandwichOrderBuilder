package com.pluralsight.SandwichBuilder;

import com.pluralsight.BaseClasses.*;

import java.util.ArrayList;
import java.util.List;

// Class representing a sandwich, extending Item

public class Sandwich extends Item {
    public String size; // Size of the sandwich (e.g., 4, 8, 12 inches)
    public Bread bread; // Type of bread
    public List<Topping> toppings = new ArrayList<>(); // List of toppings
    public boolean isToasted; // Whether the sandwich is toasted
    public int extraCheese; // Extra cheese option
    public int extraMeat; // Extra meat option
    public boolean hasAuJus; //extra sauce option to add au jus sauce

    // Constructor to initialize a sandwich
    public Sandwich(String name, String size, Bread bread) {
        super(name); // Call the constructor of the Item class
        this.size = size;
        this.bread = bread;
    }

    // Method to add a topping to the sandwich
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Method to set the amount of extra cheese
    public void setExtraCheese(int extraCheese) {
        this.extraCheese = extraCheese;
    }

    // Method to set the amount of extra meat
    public void setExtraMeat(int extraMeat) {
        this.extraMeat = extraMeat;
    }

    public void setHasAuJus(boolean hasAuJus) {
        this.hasAuJus = hasAuJus; //Au Jus is free regardless
    }

    // Method to calculate the base price of the sandwich based on its size
    @Override
    public double calculatePrice() {
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
    public double calculateExtraCheesePrice() {
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
    public double calculateExtraMeatPrice() {
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
    public double calculateTotalCost() {
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

