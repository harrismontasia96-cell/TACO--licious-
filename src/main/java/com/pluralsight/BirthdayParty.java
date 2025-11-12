package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BirthdayParty implements MenuItem {
    private LocalDateTime partyDateTime;
    private String bannerName;
    private String pinataAnimal;
    private String pinataColor;
    private String theme;
    private String cateringPackage;
    private int guestCount;
    private double price;

    public BirthdayParty(String bannerName, LocalDateTime partyDateTime,
                         String pinataAnimal, String pinataColor,
                         String theme, String cateringPackage,
                         int guestCount, double price) {
        this.bannerName = bannerName;
        this.partyDateTime = partyDateTime;
        this.pinataAnimal = pinataAnimal;
        this.pinataColor = pinataColor;
        this.theme = theme;
        this.cateringPackage = cateringPackage;
        this.guestCount = guestCount;
        this.price = price;
    }

    public static BirthdayParty createFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println("🎉 Let's book your birthday party!");

        System.out.print("Enter the date and time (format: yyyy-MM-dd HH:mm): ");
        String dateTimeInput = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeInput, formatter);

        System.out.print("Enter the name to display on the party banner: ");
        String name = scanner.nextLine();

        System.out.print("Choose a piñata animal (e.g., Unicorn, Donkey, Llama, Dragon): ");
        String animal = scanner.nextLine();

        System.out.print("Choose a piñata color (e.g., Rainbow, Blue, Pink, Gold): ");
        String color = scanner.nextLine();

        System.out.print("Choose a party theme (e.g., Tropical, Space, Princess, Fiesta): ");
        String theme = scanner.nextLine();

        System.out.print("Choose a catering package (Basic, Deluxe, or Premium): ");
        String catering = scanner.nextLine().trim();

        System.out.print("Enter the number of guests attending: ");
        int guests = Integer.parseInt(scanner.nextLine());

        // 💰 Calculate price based on package and guest count
        double basePrice = 49.99;
        double perGuest = 0.0;

        switch (catering.toLowerCase()) {
            case "basic":
                perGuest = 9.99; // Single taco, chips/salsa, small drink, candy bag
                break;
            case "deluxe":
                perGuest = 14.99; // Two tacos, chips/salsa, medium drink, candy bag
                break;
            case "premium":
                perGuest = 21.99; // Three tacos, rice/beans, large drink, cactus
                break;
            default:
                System.out.println("⚠ Invalid catering option. Defaulting to Basic.");
                catering = "Basic";
                perGuest = 9.99;
        }

        double totalPrice = basePrice + (perGuest * guests);

        System.out.println("🎂 Birthday party booked successfully!");
        return new BirthdayParty(name, dateTime, animal, color, theme, catering, guests, totalPrice);
    }

    @Override
    public String getDescription() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm a");

        String cateringDetails;

        switch (cateringPackage.toLowerCase()) {
            case "basic":
                cateringDetails = "🌮 Single taco serving, chips & salsa, one small drink, and a Mexican candy bag.";
                break;
            case "deluxe":
                cateringDetails = "🌮 Two taco servings, chips & salsa, one medium drink, and a Mexican candy bag.";
                break;
            case "premium":
                cateringDetails = "🌮 Three taco servings, rice & beans, bag of chips with salsa, one large drink, a Mexican candy bag, and a take-home miniature cactus plant.";
                break;
            default:
                cateringDetails = "Custom catering details not available.";
                break;
        }


        return "\n🎉 Birthday Party for: " + bannerName +
                "\n📅 Date: " + partyDateTime.format(formatter) +
                "\n🎈 Theme: " + theme +
                "\n🪅 Piñata: " + pinataColor + " " + pinataAnimal +
                "\n🍽 Catering Package: " + cateringPackage +
                "\n👥 Guest Count: " + guestCount +
                "\n" + cateringDetails +
                "\n💰 Total Price: $" + String.format("%.2f", price);
    }

    @Override
    public double getPrice() {
        return price;
    }
}