package com.pluralsight;

import java.util.Scanner;

class UserInterface {

    static Sandwich createSandwich() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of the sandwich (4/8/12 inch): ");
        String size = scanner.nextLine();

        System.out.println("Enter bread type (white/wheat/rye/wrap/hero): ");
        String breadType = scanner.nextLine();
        Bread bread = new Bread(breadType);

        Sandwich sandwich = new Sandwich("Custom Sandwich", size, bread);

        System.out.println("Do you want the sandwich toasted? (yes/no): ");
        String toasted = scanner.nextLine();
        sandwich.isToasted = toasted.equalsIgnoreCase("yes");

        String addMoreToppings;
        do {
            System.out.println("Available toppings: \n" +
                    "Regular: Lettuce, Tomato, Pickles, Peppers, Onions, Jalapenos, Cucumbers, Guacamole, Mushrooms\n" +
                    "Premium: Steak, Ham, Salami, Roast Beef, Chicken, Bacon, American, Provolone, Cheddar, Swiss, Avocado\n" +
                    "Sauces: Mayo, Garlic Aioli, Thousand Island, Mustard, Ranch, Vinaigrette, Ketchup, Oil and Vinegar");
            System.out.println("Add a topping (name): ");
            String toppingName = scanner.nextLine();

            if (toppingName.equalsIgnoreCase("American") ||
                    toppingName.equalsIgnoreCase("Provolone") ||
                    toppingName.equalsIgnoreCase("Cheddar") ||
                    toppingName.equalsIgnoreCase("Swiss")) {
                toppingName += " Cheese";
            }
            Topping topping = new Topping(toppingName);
            sandwich.addTopping(topping);

            System.out.println("Add another topping? (yes/no): ");
            addMoreToppings = scanner.nextLine();
        } while (addMoreToppings.equalsIgnoreCase("yes"));

        System.out.println("Would you like extra cheese? (yes/no): ");
        String extraCheese = scanner.nextLine();
        if (extraCheese.equalsIgnoreCase("yes")) {
            Topping extraCheeseTopping = new Topping("Extra Cheese");
            sandwich.addTopping(extraCheeseTopping);
        }

        System.out.println("Would you like extra meat? (yes/no): ");
        String extraMeat = scanner.nextLine();
        if (extraMeat.equalsIgnoreCase("yes")) {
            Topping extraMeatTopping = new Topping("Extra Meat");
            sandwich.addTopping(extraMeatTopping);
        }

        return sandwich;
    }

    static Drink createDrink() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available drinks: Orange Soda, Grape Soda, Pepsi, Sprite, Iced Tea, Lemonade, Mango Lemonade, Fruit Punch, Seltzer, Vitamin Water");
        System.out.println("Select a drink: ");
        String drinkType = scanner.nextLine();

        System.out.println("Enter size of the drink (Small/Medium/Large): ");
        String size = scanner.nextLine();
        return new Drink(drinkType, size);
    }

    static Chips createChips() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available chips: Doritos Cool Ranch, Hot Cheetos, Lays Potato Chips, Sour Cream and Onion, Kettle Chips, Funyuns");
        System.out.println("Select a type of chips: ");
        String chipType = scanner.nextLine();
        return new Chips(chipType);
    }

    static void displayWelcomeMessage() {
        System.out.println("Welcome to Lexx's Deli! Ready to order a sandwich?");
    }

    // Method to show checkout options
    static void showCheckoutOptions(Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Here are your order details:");
        for (Item item : order.items) {
            System.out.println("Item: " + item.name + " - $" + item.calculatePrice());
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
