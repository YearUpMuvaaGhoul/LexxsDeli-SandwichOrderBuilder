package com.pluralsight;

import java.util.Scanner;

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
        String addMoreToppings = "";
        do {
            // Display available toppings
            System.out.println("Available toppings: \n" +
                    "Regular: Lettuce, Tomato, Pickles, Peppers, Onions, Jalapenos, Cucumbers, Guacamole, Mushrooms\n" +
                    "Premium: Steak, Ham, Salami, Roast Beef, Chicken, Bacon, American Cheese, Provolone Cheese, Cheddar Cheese, Swiss Cheese, Avocado\n" +
                    "Sauces: Mayo, Garlic Aioli, Thousand Island, Mustard, Ranch, Vinaigrette, Ketchup, Oil and Vinegar");
            // Prompt for topping selection by number
            System.out.println("Enter topping number: \n1. Lettuce\n2. Tomato\n3. Pickles\n4. Peppers\n5. Onions\n6. Jalapenos\n7. Cucumbers\n8. Guacamole\n9. Mushrooms\n10. Steak\n11. Ham\n12. Salami\n13. Roast Beef\n14. Chicken\n15. Bacon\n16. American Cheese\n17. Provolone Cheese\n18. Cheddar Cheese\n19. Swiss Cheese\n20. Avocado\n21. Mayo\n22. Garlic Aioli\n23. Thousand Island\n24. Mustard\n25. Ranch\n26. Vinaigrette\n27. Ketchup\n28. Oil and Vinegar");
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
        } while (addMoreToppings.equalsIgnoreCase("yes"));

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
                System.out.println("Extra Cheese: " + (sandwich.extraCheese > 0 ? "Yes" : "No"));
                System.out.println("Extra Meat: " + (sandwich.extraMeat > 0 ? "Yes" : "No"));
                System.out.println("Total: $" + sandwich.calculateTotalCost());
            } else {
                System.out.println("Item: " + item.name + " - $" + item.calculatePrice());
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
