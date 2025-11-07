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
    @Override// an METHOD that has override-equivalent to that of any public method declared in Object.
    public double getPrice() {//getter for price of drink
        switch(size) {//switch statement to test against multiple possible values
            case SMALL: return 1.5;// Case - a possible match for (Value) being tested
            case MEDIUM: return 2.0;//key word return to call on - the return of said (value)
            case LARGE: return 2.5;
        }
        return 0;
    }

    @Override// an METHOD that has override-equivalent to that of any public method declared in Object.
    public String getDescription() {//getter for description of drink option
        return size + " " + flavor + " drink";//return size and flavor of drink
    }
}


