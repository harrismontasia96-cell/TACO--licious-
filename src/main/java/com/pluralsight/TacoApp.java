package com.pluralsight;

import java.util.Scanner;

public class TacoApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("=== Welcome to tacolicious! ===\n ===");
            System.out.println("1) New Taco Order");
            System.out.println("0) Exit");
            String choice = scanner.nextLine();
            switch (choice) {
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

    private static Drink addDrink() {
        System.out.println("Select drink size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        String sizeChoice = scanner.nextLine();
        Drink.Size size = Drink.Size.MEDIUM;
        switch (sizeChoice) {
            case "1":
                size = Drink.Size.SMALL;
                break;
            case "2":
                size = Drink.Size.MEDIUM;
                break;
            case "3":
                size = Drink.Size.LARGE;
                break;
        }
        System.out.println("Enter flavor:");
        String flavor = scanner.nextLine();
        Drink drink = new Drink(size, flavor);
        System.out.println("Added " + drink.getDescription());
        return drink;
    }

    private static ChipsAndSalsa addChipsAndSalsa() {
        System.out.println("Select salsa type:");
        System.out.println("1) Mild");
        System.out.println("2) Medium");
        System.out.println("3) Hot");
        String choice = scanner.nextLine();
        String salsa = "Mild";
        switch (choice) {
            case "1":
                salsa = "Mild";
                break;
            case "2":
                salsa = "Medium";
                break;
            case "3":
                salsa = "Hot";
                break;
        }
        ChipsAndSalsa chips = new ChipsAndSalsa(salsa);
        System.out.println(" Added " + chips.getDescription());
        return chips;
    }


    private static void handleOrder(Order order) {
        boolean ordering = true;
        while (ordering) {
            System.out.println("=== Tacolicious Taco Order ===");
            System.out.println("1) Add Taco");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips & Salsa");
            System.out.println("4) Customize Another Taco (copy previous)");
            System.out.println("5) Checkout");
            System.out.println("0) Cancel Order");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Taco taco = TacoBuilder.buildTaco();
                    order.addItem(taco);
                    break;

                case "2":
                    order.addItem(addDrink());
                    break;

                case "3":
                    order.addItem(addChipsAndSalsa());
                    break;

                case "4":
                    if (order.getLastTaco() == null) {
                        System.out.println("No previous taco to copy! Please add one first.");
                    } else {
                        Taco copied = new Taco(order.getLastTaco()); //  now valid
                        System.out.println("Copied previous taco. You can now tweak it.");
                        Taco customized = TacoBuilder.customizeExistingTaco(copied);
                        order.addItem(customized);
                    }
                    break;

                case "5":
                    if (order.getTacoCount() == 0 && order.getNonTacoCount() == 0) {
                        System.out.println("\nYou must order at least one taco, drink, or chips & salsa to check out!");
                        break;
                    }
                    order.displayOrder();
                    System.out.println("Confirm order? (y/n)");
                    if (scanner.nextLine().equalsIgnoreCase("y")) {
                        Receipt.save(order);
                        System.out.println("Order complete! Returning to Home Screen.");
                        ordering = false;
                    } else {
                        System.out.println("Checkout canceled. You may continue ordering.");
                    }
                    break;

                case "0":
                    System.out.println("Order canceled. Returning to Home Screen.");
                    ordering = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}




