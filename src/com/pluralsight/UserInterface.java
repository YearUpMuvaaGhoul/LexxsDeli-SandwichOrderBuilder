package com.pluralsight;

import java.util.Scanner;

class UserInterface {

    static Sandwich createSandwich() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of the sandwich (4/8/12): ");
        String size = scanner.nextLine();

        System.out.println("Enter bread type (white/wheat/rye/wrap): ");
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

            System.out.println("Enter quantity of this topping: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            Topping topping = new Topping(toppingName, quantity);
            sandwich.addTopping(topping);

            System.out.println("Add another topping? (yes/no): ");
            addMoreToppings = scanner.nextLine();
        } while (addMoreToppings.equalsIgnoreCase("yes"));

        return sandwich;
    }

    static Drink createDrink() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of the drink (Small/Medium/Large): ");
        String size = scanner.nextLine();
        return new Drink("Drink", size);
    }

    static Chips createChips() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter type of chips: ");
        String type = scanner.nextLine();
        return new Chips(type);
    }
}

