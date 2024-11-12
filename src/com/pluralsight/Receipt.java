package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Class to handle the generation and saving of receipts


        // Write the receipt to a file
        class Receipt {
            // Method to generate and save the receipt
            static void generateReceipt(Order order, String customerName) {
                String receipt = "Receipt:\n";

                // Generate a unique filename based on the current date and time, name

                receipt += "Customer Name: " + customerName + "\n";
                receipt += "Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "\n";
                receipt += "-----------------------------\n";
                for (Item item : order.items) {
                    receipt += "Item: " + item.name + " - $" + item.calculatePrice() + "\n";
                }
                receipt += "-----------------------------\n";
                receipt += "Total: $" + order.calculateTotal() + "\n";

                // Ensure the receipts directory exists
                File directory = new File("receipts");
                if (!directory.exists()) {
                    directory.mkdir();
                }

                String filename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
                try (FileWriter writer = new FileWriter(new File(directory, filename))) {
                    writer.write(receipt);
                    System.out.println(receipt); // Print receipt details to the console for verification
                    System.out.println("Receipt saved as " + filename);
                } catch (IOException e) {
                    System.out.println("An error occurred while saving the receipt: " + e.getMessage());
                }
            }
        }
