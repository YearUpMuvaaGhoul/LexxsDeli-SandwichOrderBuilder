package com.pluralsight;

public class Main {
        public static void main(String[] args) {
            Order order = new Order();

            order.takeOrder();

            // Calculate total and generate receipt
            order.calculateTotal();
            Receipt.generateReceipt(order);
        }
    }
