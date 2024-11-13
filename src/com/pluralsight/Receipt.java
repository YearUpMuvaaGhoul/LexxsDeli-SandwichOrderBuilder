package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Receipt {
    // Method to generate and save the receipt
    static void generateReceipt(Order order, String customerName) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Receipt:\n");
        receipt.append("Customer Name: ").append(customerName).append("\n");
        receipt.append("Date: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))).append("\n");
        receipt.append("-----------------------------\n");
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
            } else {
                receipt.append("Item: ").append(item.name).append(" - $").append(item.calculatePrice()).append("\n");
            }
        }
        receipt.append("-----------------------------\n");
        receipt.append("Total: $").append(order.calculateTotal()).append("\n");

        // Ensure the receipts directory exists
        File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdir();
        }

        String filename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
        try (FileWriter writer = new FileWriter(new File(directory, filename))) {
            writer.write(receipt.toString());
            System.out.println(receipt);
            System.out.println("Receipt saved as " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the receipt: " + e.getMessage());
        }
    }
}
