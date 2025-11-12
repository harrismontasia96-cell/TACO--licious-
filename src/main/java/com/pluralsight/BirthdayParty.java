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

    // Expanded constructor
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
        String catering = scanner.nextLine();

        System.out.print("Enter the number of guests attending: ");
        int guests = Integer.parseInt(scanner.nextLine());

        //  calculate price based on guest count
        double price = 49.99 + (guests * 5);

        System.out.println("🎂 Birthday party booked successfully!");
        return new BirthdayParty(name, dateTime, animal, color, theme, catering, guests, price);
    }

    @Override
    public String getDescription() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm a");
        return "🎉 Birthday Party for " + bannerName +
                "\n📅 Date: " + partyDateTime.format(formatter) +
                "\n🎈 Theme: " + theme +
                "\n🍽 Catering: " + cateringPackage +
                "\n👥 Guests: " + guestCount +
                "\n🪅 Piñata: " + pinataColor + " " + pinataAnimal;
    }

    @Override
    public double getPrice() {
        return price;
    }
}