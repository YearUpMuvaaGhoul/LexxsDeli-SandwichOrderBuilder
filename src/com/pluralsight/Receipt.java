package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Receipt {
    static void generateReceipt(Order order) {
        String receipt = "Receipt:\n";
        for (Item item : order.items) {
            receipt += "Item: " + item.name + " - $" + item.calculatePrice() + "\n";
        }
        receipt += "Total: $" + order.calculateTotal() + "\n";

        String filename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
        try (FileWriter writer = new FileWriter("receipts/" + filename)) {
            writer.write(receipt);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the receipt.");
        }
    }
}
