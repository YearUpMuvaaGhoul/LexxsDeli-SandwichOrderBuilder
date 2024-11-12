package com.pluralsight;

public class Main {
        public static void main(String[] args) {
            Order order = new Order();

            // Display welcome message and take order
            order.takeOrder();

            // Calculate total price and generate receipt
            order.calculateTotal();
            Receipt.generateReceipt(order);
        }
    }
