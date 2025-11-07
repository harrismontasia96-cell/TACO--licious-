package com.pluralsight;

public class Topping {
    private String name;//My parameters (Variables)/(Objects
    private boolean premium;//input for my methods or constructors to call on
    private double price;

    //Constructor method to construct my (Objects)
    public Topping(String name, boolean premium, double price) {
        this.name = name;//keyword This to refer to the current (Object)
        this.premium = premium;    //Passing the Parameter the Constructor
        this.price = price;
    }

    public String getName() { return name; } //using get to retrieve a value
    public boolean isPremium() { return premium; }
    public double getPrice() { return price; }
}

