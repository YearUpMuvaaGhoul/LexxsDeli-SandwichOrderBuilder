package com.pluralsight;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                // ANSI escape codes for colors
                String pink = "\033[95m";
                String reset = "\033[0m"; // Reset color to default

                System.out.println(
                   pink + """
                           =========================================
                              🥪 Welcome to Lexx's Bodega Deli! 🥪
                           =========================================
                                 Home of Tasty Sandwiches,         
                                  Refreshing Drinks, and           
                                   Crunchy Chips Galore!           
                           =========================================
                                   Let’s Get Started!             
                           =========================================
                           Enter 1 to start a new order or 0 to exit
                           =========================================
                           """ + reset);
               // System.out.println(":");
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

