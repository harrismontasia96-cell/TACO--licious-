package com.pluralsight;

public class Topping {
    private String name;
    private boolean premium;
    private double price;

    public Topping(String name, boolean premium, double price) {
        this.name = name;
        this.premium = premium;
        this.price = price;
    }

    public String getName() { return name; }
    public boolean isPremium() { return premium; }
    public double getPrice() { return price; }
}

