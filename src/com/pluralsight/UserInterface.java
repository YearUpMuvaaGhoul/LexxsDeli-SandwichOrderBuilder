package com.pluralsight;

import java.util.Scanner;

class UserInterface {

    static Sandwich createSandwich() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of the sandwich (4/8/12): ");
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
            System.out.println("Available toppings: " + Topping.toppingMenu.keySet());
            System.out.println("Add a topping (name): ");
            String toppingName = scanner.nextLine();

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
}
