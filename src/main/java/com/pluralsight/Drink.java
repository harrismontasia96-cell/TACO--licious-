package com.pluralsight;

//Using implements so this class can agree with and fallowing
//structure defined by my Interface
public class Drink implements MenuItem {
    public enum Size { SMALL, MEDIUM, LARGE }//Ordinals/Value) - 0,1,2

    private Size size;//My parameters (Variables)/(Objects)
    private String flavor;

    //Constructor method to construct my (Objects)
    public Drink(Size size, String flavor) {
        this.size = size;//keyword This to refer to the current (Object)
        this.flavor = flavor;
    }
    @Override
    public double getPrice() {
        switch(size) {
            case SMALL: return 1.5;
            case MEDIUM: return 2.0;
            case LARGE: return 2.5;
        }
        return 0;
    }

    @Override
    public String getDescription() {
        return size + " " + flavor + " drink";
    }
}


