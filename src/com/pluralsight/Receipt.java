package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Class to handle the generation and saving of receipts
class Receipt {
    static void generateReceipt(Order order) {
        // Construct the receipt string
        String receipt = "Receipt:\n";
        for (Item item : order.items) {
            receipt += "Item: " + item.name + " - $" + item.calculatePrice() + "\n";
        }
        receipt += "Total: $" + order.calculateTotal() + "\n";

        // Generate a unique filename based on the current date and time
        String filename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        // Ensure the receipts directory exists
        File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Write the receipt to a file
        try (FileWriter writer = new FileWriter(new File(directory, filename))) {
            writer.write(receipt);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the receipt: " + e.getMessage());
        }
    }
}
