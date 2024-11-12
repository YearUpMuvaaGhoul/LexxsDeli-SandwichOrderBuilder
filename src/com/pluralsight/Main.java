package com.pluralsight;

public class Main {

        public static void main(String[] args) {
            while (true) {
                Order order = new Order();

                // Display welcome message and take order
                order.takeOrder();

                // Show checkout options
                UserInterface.showCheckoutOptions(order);
            }
        }
    }
