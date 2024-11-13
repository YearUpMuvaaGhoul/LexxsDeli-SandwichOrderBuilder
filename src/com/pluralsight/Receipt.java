package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Receipt {

    // Method to generate and save the receipt
    static void generateReceipt(Order order, String customerName) {

        // Create a StringBuilder to build the receipt text
        StringBuilder receipt = new StringBuilder();

        // Append receipt header information
        receipt.append("Receipt:\n");
        receipt.append("Customer Name: ").append(customerName).append("\n");
        receipt.append("Date: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))).append("\n");
        receipt.append("-----------------------------\n");

        // Iterate through each item in the order and append its details to the receipt
        for (Item item : order.items) {
            if (item instanceof Sandwich) {
                Sandwich sandwich = (Sandwich) item;
                receipt.append("Item: ").append(sandwich.name).append("\n");
                receipt.append("  Size: ").append(sandwich.size).append("\n");
                receipt.append("  Bread: ").append(sandwich.bread.type).append("\n");
                receipt.append("  Toasted: ").append(sandwich.isToasted ? "Yes" : "No").append("\n");
                receipt.append("  Toppings:\n");
                for (Topping topping : sandwich.toppings) {
                    receipt.append("    - ").append(topping.name).append(" ($").append(topping.calculatePrice(sandwich.size)).append(")\n");
                }
                receipt.append("  Extra Cheese: ").append(sandwich.extraCheese > 0 ? "Yes" : "No").append("\n");
                receipt.append("  Extra Meat: ").append(sandwich.extraMeat > 0 ? "Yes" : "No").append("\n");
                receipt.append("  Total: $").append(sandwich.calculateTotalCost()).append("\n");
            } else if (item instanceof Drink) {
                Drink drink = (Drink) item;
                // Append drink details, including name, size, and price
                receipt.append("Drink: ").append(drink.name).append(" (").append(drink.size).append(") - $").append(drink.calculatePrice()).append("\n");
            } else if (item instanceof Chips) {
                Chips chips = (Chips) item;
                // Append chips details, including name and price fixed at 1.50
                receipt.append("Chips: ").append(chips.name).append(" - $").append(chips.calculatePrice()).append("\n");
            } else {
                // Append details for any other item types
                receipt.append("Item: ").append(item.name).append(" - $").append(item.calculatePrice()).append("\n");
            }
        }

        // Append the total cost of the order
        receipt.append("-----------------------------\n");
        receipt.append("Total: $").append(order.calculateTotal()).append("\n");

        // Ensure the receipts directory exists, create if not
        File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Create a unique filename based on the current date and time
        String filename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        // Write the receipt to a file
        try (FileWriter writer = new FileWriter(new File(directory, filename))) {
            writer.write(receipt.toString());
            // Print the receipt to the console
            System.out.println(receipt);
            System.out.println("Receipt saved as " + filename);
        } catch (IOException e) {
            // Handle any errors that occur during file writing
            System.out.println("An error occurred while saving the receipt: " + e.getMessage());
        }
    }
}
