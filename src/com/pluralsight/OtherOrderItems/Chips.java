package com.pluralsight.OtherOrderItems;

import com.pluralsight.BaseClasses.*;

// Class representing chips, extending Item
public class Chips extends Item {
    String type; // Type of chips

    public Chips(String type, double chipsPrice) {
        super(type);
        this.type = type;
    }

    @Override
    public double calculatePrice() {
        return 1.50; // Fixed price for all chips
    }
}
