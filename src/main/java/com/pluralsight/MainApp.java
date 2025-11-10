package com.pluralsight;

import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Order order = new Order();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Tacolicious Menu ===");
            System.out.println("1) Add Taco");
            System.out.println("2) View Order");
            System.out.println("3) Checkout");
            System.out.println("0) Exit");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> handleAddTaco();
                case "2" -> order.displayOrder();
                case "3" -> checkout();
                case "0" -> running = false;
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void handleAddTaco() {
        if (order.getTacoCount() > 0) {
            System.out.println("1) Create a new taco from scratch");
            System.out.println("2) Customize another taco (copy previous settings)");
            System.out.println("0) Cancel");
            String tacoChoice = scanner.nextLine();

            switch (tacoChoice) {
                case "1" -> order.addItem(TacoBuilder.buildTaco());
                case "2" -> {
                    Taco lastTaco = order.getLastTaco();
                    if (lastTaco != null) {
                        Taco copied = lastTaco.copy();
                        Taco customized = TacoBuilder.customizeExistingTaco(copied);
                        order.addItem(customized);
                    } else {
                        System.out.println("No previous taco found. Starting fresh!");
                        order.addItem(TacoBuilder.buildTaco());
                    }
                }
                default -> System.out.println("Cancelled taco creation.");
            }
        } else {
            order.addItem(TacoBuilder.buildTaco());
        }
    }

    private static void checkout() {
        order.displayOrder();
        System.out.println("Thank you for visiting Tacolicious! 🌮");
    }
}

