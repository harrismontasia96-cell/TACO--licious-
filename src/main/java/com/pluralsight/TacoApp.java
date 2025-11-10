package com.pluralsight;

import java.util.Scanner;

public class TacoApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[]args) {
        boolean running = true;
        while(running) {
            System.out.println("=== Welcome to tacolicious! ===\n ===");
            System.out.println("1) New Taco Order");
            System.out.println("0) Exit");
            String choice = scanner.nextLine();
            switch(choice) {
                case "1":
                    Order order = new Order();
                    handleOrder(order);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void handleOrder(Order order) {
        boolean ordering = true;
        while(ordering) {
            System.out.println("=== Taco Taco Order ===");
            System.out.println("1) Add Taco");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips & Salsa");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            String choice = scanner.nextLine();
            switch(choice) {
                case "1":
                    // Call method to add Taco
                    break;
                case "2":
                    // Call method to add Drink
                    break;
                case "3":
                    // Call method to add Chips & Salsa
                    break;
                case "4":
                    order.displayOrder();
                    System.out.println("Confirm order? (y/n)");
                    if(scanner.nextLine().equalsIgnoreCase("y")) {
                        Receipt.save(order);
                        ordering = false;
                    }
                    break;
                case "0":
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}



