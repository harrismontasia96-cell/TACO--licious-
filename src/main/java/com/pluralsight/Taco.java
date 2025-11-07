package com.pluralsight;

import java.util.List;

public class Taco implements MenuItem{
    public enum Size { SINGLE, THREE_TACO_PLATE, BURRITO }
    public enum Shell { CORN, FLOUR, HARD_SHELL, BOWL }

    private Size size;
    private Shell shell;
    private List<Topping> toppings;
    private boolean deepFried;

    public Taco(Size size, Shell shell, List<Topping> toppings, boolean deepFried) {
        this.size = size;
        this.shell = shell;
        this.toppings = toppings;
        this.deepFried = deepFried;
    }

    @Override
    public double getPrice() {
        double price = 0;
        switch(size) {
            case SINGLE: price += 3.0; break;
            case THREE_TACO_PLATE: price += 8.0; break;
            case BURRITO: price += 7.0; break;
        }
        for(Topping t : toppings) {
            if(t.isPremium()) price += t.getPrice();
        }
        if(deepFried) price += 1.0; // extra for deep fried
        return price;
    }

    @Override
    public String getDescription() {
        StringBuilder desc = new StringBuilder(size + " taco with " + shell + " shell, toppings: ");
        for(Topping t : toppings) {
            desc.append(t.getName()).append(", ");
        }
        if(deepFried) desc.append("deep fried");
        return desc.toString();
    }
}

