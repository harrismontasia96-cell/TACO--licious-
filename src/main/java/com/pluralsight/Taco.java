package com.pluralsight;

import java.util.List;

                  //Using implements so this class can agree with and fallowing
                  //structure defined by my Interface
public class Taco implements MenuItem{
    public enum Size { SINGLE, THREE_TACO_PLATE, BURRITO } //Ordinals/Value) - 0,1,2
    public enum Shell { CORN, FLOUR, HARD_SHELL, BOWL }//Ordinals/(Value) - 0,1,2,3

    private Size size;//My parameters (Variables)/(Objects)
    private Shell shell;     //input for my methods or constructors to call on
    private List<Topping> toppings;
    private boolean deepFried;

                                   //Constructor method to construct my (Objects)
    public Taco(Size size, Shell shell, List<Topping> toppings, boolean deepFried) {
        this.size = size;//keyword This to refer to the current (Object)
        this.shell = shell;             //Passing the Parameter the Constructor
        this.toppings = toppings;
        this.deepFried = deepFried;
    }

    @Override// an METHOD that has override-equivalent to that of any public method declared in Object.
    public double getPrice() {
        double price = 0;
        switch(size) {//our switch statement to test against multiple possible values
            case SINGLE: price += 3.0; break; // Case - a possible match for (Value) being tested
            case THREE_TACO_PLATE: price += 8.0; break;  //Break stops the switch statement
            case BURRITO: price += 7.0; break;           //once a match is found and to prevent Fall-Through
        }
        for(Topping t : toppings) {         // if statement made inside a for loop
            if(t.isPremium()) price += t.getPrice();// checking if the condition is
        }                                          //premium if :yes Adding additional pricing
        if(deepFried) price += 1.0; //checking condition if user input is
        return price;                 //wanting DeepFried it is extra for DeepFried
    }

    @Override// an METHOD that has override-equivalent to that of any public method declared in Object.
    public String getDescription() {//using StringBuilder so im able to append,insert,delete,modify my string without having to make a new one every time
        StringBuilder desc = new StringBuilder(size + " taco with " + shell + " shell, toppings: ");
        for(Topping t : toppings) {
            desc.append(t.getName()).append(", ");// using append to add or append (Variables)
        }                                         // at the end of an existing StringBuilder
        if(deepFried) desc.append("deep fried");
        return desc.toString();
    }
}

