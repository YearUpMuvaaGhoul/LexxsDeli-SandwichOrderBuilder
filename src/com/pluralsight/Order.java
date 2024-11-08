package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Order {
    List<Item> items = new ArrayList<>();
    double totalPrice;

    void addItem(Item item) {
        items.add(item);
    }

    double calculateTotal() {
        totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.calculatePrice();
        }
        return totalPrice;
    }

    void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        UserInterface.displayWelcomeMessage();
        String choice;
        do {
            System.out.println("Add item to your order: (sandwich/drink/chips): ");
            String itemType = scanner.nextLine();
            if (itemType.equalsIgnoreCase("sandwich")) {
                Sandwich sandwich = UserInterface.createSandwich();
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
