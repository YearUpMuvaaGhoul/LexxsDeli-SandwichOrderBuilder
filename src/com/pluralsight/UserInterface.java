package com.pluralsight;

import java.util.Scanner;

class UserInterface {

    // Method to take the user's order
    static void takeOrder(Order order) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for sandwich size
        System.out.println("Enter size of the sandwich (4/8/12): ");
        String size = scanner.nextLine();

        // Prompt for bread type
        System.out.println("Enter bread type (white/wheat/rye/wrap/hero): ");
        String breadType = scanner.nextLine();
        Bread bread = new Bread(breadType);

        // Create a new sandwich
        Sandwich sandwich = new Sandwich("Custom Sandwich", size, bread);

        // Prompt for toasted option
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

            // Prompt to add another topping
            System.out.println("Add another topping? (yes/no): ");
            addMoreToppings = scanner.nextLine();
        }

        // Prompt for extra cheese
        System.out.println("Would you like extra cheese? (yes/no): ");
        String extraCheese = scanner.nextLine();
        sandwich.setExtraCheese(extraCheese.equalsIgnoreCase("yes") ? 1 : 0);

        // Prompt for extra meat
        System.out.println("Would you like extra meat? (yes/no): ");
        String extraMeat = scanner.nextLine();
        sandwich.setExtraMeat(extraMeat.equalsIgnoreCase("yes") ? 1 : 0);

        // Add the sandwich to the order
        order.addItem(sandwich);

        // Prompt for drink options
        System.out.println("Would you like to add a drink? (yes/no): ");
        String addDrink = scanner.nextLine();
        if (addDrink.equalsIgnoreCase("yes")) {
            System.out.println("Select a drink:");
            System.out.println("1. Pepsi, 2. Lemonade, 3. Mango Lemonade, 4. Mountain Dew, 5. Seltzer, 6. Vitamin Water, 7. Aloe Vera Drink, 8. Fruit Punch");
            System.out.println("Enter drink number: ");
            int drinkNumber = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            // Map the drink number to the drink name
            String drinkName = "";
            switch (drinkNumber) {
                case 1: drinkName = "Pepsi"; break;
                case 2: drinkName = "Lemonade"; break;
                case 3: drinkName = "Mango Lemonade"; break;
                case 4: drinkName = "Mountain Dew"; break;
                case 5: drinkName = "Seltzer"; break;
                case 6: drinkName = "Vitamin Water"; break;
                case 7: drinkName = "Aloe Vera Drink"; break;
                case 8: drinkName = "Fruit Punch"; break;
                default: System.out.println("Invalid drink number. Please try again.");
            }

            // Prompt for drink size
            System.out.println("Select a size: 1. Small ($2.00), 2. Medium ($2.50), 3. Large ($3.00)");
            int drinkSize = scanner.nextInt();
            scanner.nextLine();  // Consume the newline
            double drinkPrice = 0;
            switch (drinkSize) {
                case 1: drinkPrice = 2.00; break;
                case 2: drinkPrice = 2.50; break;
                case 3: drinkPrice = 3.00; break;
                default: System.out.println("Invalid size. Defaulting to Small ($2.00)"); drinkPrice = 2.00; break;
            }

            // Add the drink to the order
            Drink drink = new Drink(drinkName, (drinkSize == 1 ? "Small" : drinkSize == 2 ? "Medium" : "Large"));
            //Use Drink subclass
            order.addItem(drink);
        }

        // Prompt for chips options
        System.out.println("Would you like to add chips? (yes/no): ");
        String addChips = scanner.nextLine();
        if (addChips.equalsIgnoreCase("yes")) {
            System.out.println("Select a type of chips:");
            System.out.println("1. Regular Chips, 2. BBQ Chips, 3. Sour Cream & Onion Chips, 4. Salt & Vinegar Chips, 5. Jalapeno Chips, 6. Hot Cheetos, 7. Kettle Chips, 8. Lays Potato Chips, 9. Funyuns");
            System.out.println("Enter chips number: ");
            int chipsNumber = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            // Map the chips number to the chips name
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
                default: System.out.println("Invalid chips number. Please try again.");
            }

            // Set price for chips
            double chipsPrice = 1.50;

            // Add the chips to the order
            Chips chips = new Chips(chipsName, chipsPrice);
            // Use Chips subclass
            order.addItem(chips);
        }
    }

    // Method to show checkout options and confirm or cancel the order
    static void showCheckoutOptions(Order order) {
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
