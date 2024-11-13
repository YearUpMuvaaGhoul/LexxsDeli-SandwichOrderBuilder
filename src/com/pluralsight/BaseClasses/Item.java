package com.pluralsight.BaseClasses;

// Abstract class representing an item in the order. this is the base class
public abstract class Item {
    public String name; // Name of the item
    public double price; // Price of the item


    protected Item(String name) {
        this.name = name;
    }

    // Abstract method to calculate price, implemented by subclasses
    public abstract double calculatePrice();
}

//The Item class is designed as an abstract class to provide
// a common base for all items (like sandwiches, drinks, and chips) without being instantiated on its own

// class sandwich will (extend) / inherit items, as well as drink and chips class