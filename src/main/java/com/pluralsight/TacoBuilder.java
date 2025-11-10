package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TacoBuilder {
    private static Scanner scanner = new Scanner(System.in);

    public static Taco buildTaco() {
        System.out.println("=== Create Your Taco ===");

        // Step 1: Select size
        Taco.Size size = selectSize();

        // Step 2: Select shell
        Taco.Shell shell = selectShell();

        // Step 3: Add toppings
        List<Topping> toppings = selectToppings();

        // Step 4: Deep fried?
        boolean deepFried = askDeepFried();

        Taco taco = new Taco(size, shell, toppings, deepFried);

        System.out.println("\n Tacolicious Taco added: " + taco.getDescription());
        System.out.println("💲 Price: $" + taco.getPrice());
        return taco;
    }

    private static Taco.Size selectSize() {
        System.out.println("Select Tacolicious size:");
        System.out.println("1) Single Taco");
        System.out.println("2) 3-Taco Plate");
        System.out.println("3) BurritoLicious");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1": return Taco.Size.SINGLE;
            case "2": return Taco.Size.THREE_TACO_PLATE;
            case "3": return Taco.Size.BURRITO;
            default:
                System.out.println("Invalid choice. Defaulting to Single Taco.");
                return Taco.Size.SINGLE;
        }
    }

    private static Taco.Shell selectShell() {
        System.out.println("Select your shell type:");
        System.out.println("1) Corn");
        System.out.println("2) Flour");
        System.out.println("3) Hard Shell");
        System.out.println("4) Bowl");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1": return Taco.Shell.CORN;
            case "2": return Taco.Shell.FLOUR;
            case "3": return Taco.Shell.HARD_SHELL;
            case "4": return Taco.Shell.BOWL;
            default:
                System.out.println("Invalid choice. Defaulting to Flour.");
                return Taco.Shell.FLOUR;
        }
    }

    private static List<Topping> selectToppings() {
        List<Topping> toppings = new ArrayList<>();
        boolean addingToppings = true;

        while (addingToppings) {
            System.out.println("\nAdd a topping:");
            System.out.println("1) Protein (Premium)");
            System.out.println("2) Cheese (Premium)");
            System.out.println("3) Regular Topping");
            System.out.println("4) Done adding toppings");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    toppings.add(selectProtein());
                    break;
                case "2":
                    toppings.add(selectCheese());
                    break;
                case "3":
                    toppings.add(selectRegularTopping());
                    break;
                case "4":
                    addingToppings = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        return toppings;
    }

    private static Topping selectProtein() {
        System.out.println("Select protein:");
        System.out.println("1) Chicken");
        System.out.println("2) Steak");
        System.out.println("3) Pork");
        System.out.println("4) Shrimp");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1": return new Topping("Chicken", true, 2.0);
            case "2": return new Topping("Steak", true, 2.5);
            case "3": return new Topping("Pork", true, 2.0);
            case "4": return new Topping("Shrimp", true, 3.0);
            default: return new Topping("Chicken", true, 2.0);
        }
    }

    private static Topping selectCheese() {
        System.out.println("Select cheese:");
        System.out.println("1) Cheddar");
        System.out.println("2) Queso Fresco");
        System.out.println("3) Mozzarella");
        System.out.println("4) Vegan Cheese");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1": return new Topping("Cheddar", true, 1.0);
            case "2": return new Topping("Queso Fresco", true, 1.5);
            case "3": return new Topping("Mozzarella", true, 1.0);
            case "4": return new Topping("Vegan Cheese", true, 1.5);
            default: return new Topping("Cheddar", true, 1.0);
        }
    }

    private static Topping selectRegularTopping() {
        System.out.println("Select regular topping:");
        System.out.println("1) Lettuce");
        System.out.println("2) Tomato");
        System.out.println("3) Onion");
        System.out.println("4) Jalapenos");
        System.out.println("5) Guacamole");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1": return new Topping("Lettuce", false, 0.0);
            case "2": return new Topping("Tomato", false, 0.0);
            case "3": return new Topping("Onion", false, 0.0);
            case "4": return new Topping("Jalapenos", false, 0.0);
            case "5": return new Topping("Guacamole", false, 0.0);
            default: return new Topping("Lettuce", false, 0.0);
        }
    }

    private static boolean askDeepFried() {
        System.out.println("Would you like your taco deep fried? (y/n)");
        return scanner.nextLine().equalsIgnoreCase("y");
    }
}

