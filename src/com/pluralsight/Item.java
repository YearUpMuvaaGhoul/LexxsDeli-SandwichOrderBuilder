package com.pluralsight;

abstract class Item {
    String name;
    double price;

    Item(String name) {
        this.name = name;
    }

    abstract double calculatePrice();
}
//The Item class is designed as an abstract class to provide
// a common base for all items (like sandwiches, drinks, and chips) without being instantiated on its own

// class sandwich will (extend) / inherit items, as well as drink and chips class