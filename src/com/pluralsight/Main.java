package com.pluralsight;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Welcome to Lexx's Deli! Enter 1 to start a new order or 0 to exit:");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline
                if (choice == 0) {
                    System.out.println("Exiting... Have a great day!");
                    break;
                }
                if (choice == 1) {
                    Order order = new Order();
                    UserInterface.takeOrder(order);

                    // Show checkout options
                    UserInterface.showCheckoutOptions(order);
                }
            }
        }
    }

