package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Order {
    static List<Item> items = new ArrayList<>();
    double totalPrice;

    // Method to add an item to the order
    static void addItem(Item item) {
        items.add(item);
    }

    // Method to calculate the total price of the order
    double calculateTotal() {
        totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.calculatePrice();
        }
        return totalPrice;
    }

    // Method to take the user's order
    static void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        UserInterface.displayWelcomeMessage();
       // System.out.println("Please enter your name: ");
       // String customerName = scanner.nextLine();
        String choice;
        do {
            System.out.println("Add item to your order: (sandwich/drink/chips): ");
            String itemType = scanner.nextLine();
            if (itemType.equalsIgnoreCase("sandwich")) {
                Sandwich sandwich = UserInterface.createSandwich(); // builds sandwich
                addItem(sandwich);
            } else if (itemType.equalsIgnoreCase("drink")) {
                Drink drink = UserInterface.createDrink();
                addItem(drink);
            } else if (itemType.equalsIgnoreCase("chips")) {
                Chips chips = UserInterface.createChips();
                addItem(chips);
            }
            System.out.println("Would you like to add another item? (yes/no): ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("yes"));
    }
}
