package com.pluralsight;

// Abstract class representing an item in the order
abstract class Item {
    String name; // Name of the item
    double price; // Price of the item

    Item(String name) {
        this.name = name;
    }

    // Abstract method to calculate price, implemented by subclasses
    abstract double calculatePrice();
}

//The Item class is designed as an abstract class to provide
// a common base for all items (like sandwiches, drinks, and chips) without being instantiated on its own

// class sandwich will (extend) / inherit items, as well as drink and chips class