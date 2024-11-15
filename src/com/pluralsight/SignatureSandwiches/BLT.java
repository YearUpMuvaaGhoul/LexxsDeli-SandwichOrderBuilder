package com.pluralsight.SignatureSandwiches;

import com.pluralsight.SandwichBuilder.Bread;
import com.pluralsight.SandwichBuilder.Sandwich;

public class BLT extends Sandwich {
    private String name;
    private String[] ingredients;

    public BLT(String name, String size, Bread bread) {
        super(name, size, bread);
    }

    public void BLT() {
        this.name = "BLT";
        this.ingredients = new String[]{"Bacon", "Lettuce", "Tomato", "Mayonnaise", "Toasted Bread"};
    }

    public String display() {
        return name + " - Ingredients: " + String.join(", ", ingredients);
    }
}
