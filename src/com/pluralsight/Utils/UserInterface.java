package com.pluralsight.Utils;

import com.pluralsight.BaseClasses.Item;
import com.pluralsight.BaseClasses.Order;
import com.pluralsight.OtherOrderItems.Chips;
import com.pluralsight.OtherOrderItems.Drink;
import com.pluralsight.Utils.Receipt;
import com.pluralsight.SandwichBuilder.Bread;
import com.pluralsight.SandwichBuilder.Sandwich;
import com.pluralsight.SandwichBuilder.Topping;

import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) { // pulls from main to start UI console
        Order order = new Order();
        takeOrder(order);
        showCheckoutOptions(order);
    }

    // Method to take the user's order
   public static void takeOrder(Order order) {
        Scanner scanner = new Scanner(System.in);
        String addMoreItems = "yes";

        while (addMoreItems.equalsIgnoreCase("yes")) {
            System.out.println("What would you like to order? (Enter 'drink', 'chips', or 'sandwich')");
            String itemType = scanner.nextLine();

            switch (itemType.toLowerCase()) {
                case "drink":
                    addDrink(order, scanner);
                    break;
                case "chips":
                    addChips(order, scanner);
                    break;
                case "sandwich":
                    addSandwich(order, scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 'drink', 'chips', or 'sandwich'.");
                    continue;
            }

            System.out.println("Would you like to add another item? (yes/no): ");
            addMoreItems = scanner.nextLine();
        }
    }

   public static void addDrink(Order order, Scanner scanner) {
        System.out.println("Select a drink:");
        System.out.println("1. Orange Soda, 2. Grape Soda, 3. Pepsi, 4. Sprite, 5. Iced Tea, 6. Lemonade, 7. Mango Lemonade, 8. Fruit Punch, 9. Seltzer, 10. Vitamin Water");
        System.out.println("Enter drink number: ");
        int drinkNumber = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        String drinkName = "";
        switch (drinkNumber) {
            case 1: drinkName = "Orange Soda"; break;
            case 2: drinkName = "Grape Soda"; break;
            case 3: drinkName = "Pepsi"; break;
            case 4: drinkName = "Sprite"; break;
            case 5: drinkName = "Iced Tea"; break;
            case 6: drinkName = "Lemonade"; break;
            case 7: drinkName = "Mango Lemonade"; break;
            case 8: drinkName = "Fruit Punch"; break;
            case 9: drinkName = "Seltzer"; break;
            case 10: drinkName = "Vitamin Water"; break;
            default: System.out.println("Invalid drink number. Please try again."); return;
        }

        System.out.println("Select a size: 1. Small ($2.00), 2. Medium ($2.50), 3. Large ($3.00)");
        int drinkSize = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        Drink drink = new Drink(drinkName, (drinkSize == 1 ? "Small" : drinkSize == 2 ? "Medium" : "Large"));
        order.addItem(drink);
    }

  public static void addChips(Order order, Scanner scanner) {
        System.out.println("Select a type of chips:");
        System.out.println("1. Regular Chips, 2. BBQ Chips, 3. Sour Cream & Onion Chips, 4. Salt & Vinegar Chips, 5. Jalapeno Chips, 6. Hot Cheetos, 7. Kettle Chips, 8. Lays Potato Chips, 9. Funyuns");
        System.out.println("Enter chips number: ");
        int chipsNumber = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        String chipsName = "";
        switch (chipsNumber) {
            case 1: chipsName = "Regular Chips"; break;
            case 2: chipsName = "BBQ Chips"; break;
            case 3: chipsName = "Sour Cream & Onion Chips"; break;
            case 4: chipsName = "Salt & Vinegar Chips"; break;
            case 5: chipsName = "Jalapeno Chips"; break;
            case 6: chipsName = "Hot Cheetos"; break;
            case 7: chipsName = "Kettle Chips"; break;
            case 8: chipsName = "Lays Potato Chips"; break;
            case 9: chipsName = "Funyuns"; break;
            default: System.out.println("Invalid chips number. Please try again."); return;
        }

        Chips chips = new Chips(chipsName, 1.50);
        order.addItem(chips);
    }

 public static void addSandwich(Order order, Scanner scanner) {
        String addMoreSandwiches = "yes";

        while (addMoreSandwiches.equalsIgnoreCase("yes")) {
            System.out.println("Enter size of the sandwich (4/8/12): ");
            String size = scanner.nextLine();

            System.out.println("Enter bread type (white/wheat/rye/wrap/hero): ");
            String breadType = scanner.nextLine();
            Bread bread = new Bread(breadType);

            Sandwich sandwich = new Sandwich("Custom Sandwich", size, bread);

            System.out.println("Do you want the sandwich toasted? (yes/no): ");
            String toasted = scanner.nextLine();
            sandwich.isToasted = toasted.equalsIgnoreCase("yes");

            // Loop to add toppings
            String addMoreToppings = "yes";
            while (addMoreToppings.equalsIgnoreCase("yes")) {
                // Display available toppings
                System.out.println("Available toppings:");
                System.out.println("Regular:");
                System.out.println("1. Lettuce, 2. Tomato, 3. Pickles, 4. Peppers, 5. Onions, 6. Jalapenos, 7. Cucumbers, 8. Guacamole, 9. Mushrooms");
                System.out.println("Premium:");
                System.out.println("10. Steak, 11. Ham, 12. Salami, 13. Roast Beef, 14. Chicken, 15. Bacon, 16. American Cheese, 17. Provolone Cheese, 18. Cheddar Cheese, 19. Swiss Cheese, 20. Avocado");
                System.out.println("Sauces:");
                System.out.println("21. Mayo, 22. Garlic Aioli, 23. Thousand Island, 24. Mustard, 25. Ranch, 26. Vinaigrette, 27. Ketchup, 28. Oil and Vinegar");

                // Prompt for topping selection by number
                System.out.println("Enter topping number: ");
                int toppingNumber = scanner.nextInt();
                scanner.nextLine();  // Consume the newline

                // Map the topping number to the topping name
                String toppingName = "";
                switch (toppingNumber) {
                    case 1: toppingName = "Lettuce"; break;
                    case 2: toppingName = "Tomato"; break;
                    case 3: toppingName = "Pickles"; break;
                    case 4: toppingName = "Peppers"; break;
                    case 5: toppingName = "Onions"; break;
                    case 6: toppingName = "Jalapenos"; break;
                    case 7: toppingName = "Cucumbers"; break;
                    case 8: toppingName = "Guacamole"; break;
                    case 9: toppingName = "Mushrooms"; break;
                    case 10: toppingName = "Steak"; break;
                    case 11: toppingName = "Ham"; break;
                    case 12: toppingName = "Salami"; break;
                    case 13: toppingName = "Roast Beef"; break;
                    case 14: toppingName = "Chicken"; break;
                    case 15: toppingName = "Bacon"; break;
                    case 16: toppingName = "American Cheese"; break;
                    case 17: toppingName = "Provolone Cheese"; break;
                    case 18: toppingName = "Cheddar Cheese"; break;
                    case 19: toppingName = "Swiss Cheese"; break;
                    case 20: toppingName = "Avocado"; break;
                    case 21: toppingName = "Mayo"; break;
                    case 22: toppingName = "Garlic Aioli"; break;
                    case 23: toppingName = "Thousand Island"; break;
                    case 24: toppingName = "Mustard"; break;
                    case 25: toppingName = "Ranch"; break;
                    case 26: toppingName = "Vinaigrette"; break;
                    case 27: toppingName = "Ketchup"; break;
                    case 28: toppingName = "Oil and Vinegar"; break;
                    default: System.out.println("Invalid topping number. Please try again."); continue;
                }
                // Add the topping to the sandwich
                Topping topping = new Topping(toppingName);
                sandwich.addTopping(topping);

                System.out.println("Add another topping? (yes/no): ");
                addMoreToppings = scanner.nextLine();
            }
        // prompt for extra cheese?
            System.out.println("Would you like extra cheese? (yes/no): ");
            String extraCheese = scanner.nextLine();
            sandwich.setExtraCheese(extraCheese.equalsIgnoreCase("yes") ? 1 : 0);

         //prompt for extra meat ?
            System.out.println("Would you like extra meat? (yes/no): ");
            String extraMeat = scanner.nextLine();
            sandwich.setExtraMeat(extraMeat.equalsIgnoreCase("yes") ? 1 : 0);

            // Add the sandwich to the order
            order.addItem(sandwich);

            System.out.println("Would you like to customize another sandwich? (yes/no): ");
            addMoreSandwiches = scanner.nextLine();
        }
    }

    // Method to show checkout options and confirm or cancel the order
    public static void showCheckoutOptions(Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Here are your order details:");
        for (Item item : order.items) {
            if (item instanceof Sandwich) {
                Sandwich sandwich = (Sandwich) item;
                System.out.println("Item: " + sandwich.name + "\nSize: " + sandwich.size + "\nBread: " + sandwich.bread.type + "\nToasted: " + (sandwich.isToasted ? "Yes" : "No") + "\nToppings:");
                for (Topping topping : sandwich.toppings) {
                    System.out.println("    - " + topping.name + " ($" + topping.calculatePrice(sandwich.size) + ")");
                }
                System.out.println("Extra Cheese: " + (sandwich.extraCheese > 0 ? "Yes, $" + sandwich.calculateExtraCheesePrice() : "No"));
                System.out.println("Extra Meat: " + (sandwich.extraMeat > 0 ? "Yes, $" + sandwich.calculateExtraMeatPrice() : "No"));
                System.out.println("Total: $" + sandwich.calculateTotalCost());
            } else if (item instanceof Drink) {
                Drink drink = (Drink) item;
                System.out.println("Item: " + drink.name + " (" + drink.size + ") - $" + drink.calculatePrice());
            } else if (item instanceof Chips) {
                Chips chips = (Chips) item;
                System.out.println("Item: " + chips.name + " - $" + chips.calculatePrice());
            } else {
                System.out.println("Item: " + item.name + " - $" + item.price);
            }
        }
        System.out.println("Total: $" + order.calculateTotal());
        System.out.println("Would you like to Confirm or Cancel your order? (confirm/cancel)");

        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("confirm")) {
            System.out.println("Please enter your name: ");
            String customerName = scanner.nextLine();
            Receipt.generateReceipt(order, customerName);
        } else if (choice.equalsIgnoreCase("cancel")) {
            System.out.println("Order cancelled. Returning to home screen...");
        }
    }
}
