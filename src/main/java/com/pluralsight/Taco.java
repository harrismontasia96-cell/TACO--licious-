package com.pluralsight;

import java.util.List;
import java.util.ArrayList;
                  //Using implements so this class can agree with and fallowing
                  //structure defined by my Interface
public class Taco implements MenuItem {
                      public enum Size {SINGLE, THREE_TACO_PLATE, BURRITO} //Ordinals/Value) - 0,1,2

                      public enum Shell {CORN, FLOUR, HARD_SHELL, BOWL}//Ordinals/(Value) - 0,1,2,3

                      private Size size;//My parameters (Variables)/(Objects)
                      private Shell shell;     //input for my methods or constructors to call on
                      private List<Topping> toppings;
                      private boolean deepFried;

                      //Constructor method to construct my (Objects)
                      public Taco(Size size, Shell shell, List<Topping> toppings, boolean deepFried) {
                          this.size = size;//keyword This to refer to the current (Object)
                          this.shell = shell;             //Passing the Parameter the Constructor
                          this.toppings = toppings;
                          this.toppings = new ArrayList<>(toppings);
                          this.deepFried = deepFried;

                      }
                      public Taco(Taco other) {
                          this.shell = other.shell;
                          this.size = other.size;
                          this.deepFried = other.deepFried;
                          this.toppings = new ArrayList<>(other.toppings);
                      }

                      public Taco copy() {
                          List<Topping> copiedToppings = new ArrayList<>();
                          for (Topping t : this.toppings) {
                              copiedToppings.add(new Topping(t.getName(), t.isPremium(), t.getPrice()));
                          }
                          return new Taco(this.size, this.shell, copiedToppings, this.deepFried);
                      }

                      public Size getSize() {
                          return size;
                      }

                      public Shell getShell() {
                          return shell;
                      }

                      public List<Topping> getToppings() {
                          return toppings;
                      }

                      public boolean isDeepFried() {
                          return deepFried;
                      }

                      public void setSize(Size size) {
                          this.size = size;
                      }

                      public void setShell(Shell shell) {
                          this.shell = shell;
                      }

                      public void setToppings(List<Topping> toppings) {
                          this.toppings = toppings;
                      }

                      public void setDeepFried(boolean deepFried) {
                          this.deepFried = deepFried;
                      }


                      @Override// an METHOD that has override-equivalent to that of any public method declared in Object.
    public double getPrice() {
        double price = switch(size) {//my switch statement to test against multiple possible values
            case SINGLE -> 3.0;
            case THREE_TACO_PLATE -> 8.0;
            case BURRITO -> 7.0;
        };
                          for (Topping t : toppings) {
                              if (t.isPremium()) price += t.getPrice();
                          }
                          if (deepFried) price += 1.0;
                          return price;
                      }

    @Override// an METHOD that has override-equivalent to that of any public method declared in Object.
    public String getDescription() {//using StringBuilder so im able to append,insert,delete,modify my string without having to make a new one every time
        StringBuilder desc = new StringBuilder(size + " taco with " + shell + " shell\n ");

        List<String> proteins = new ArrayList<>();
        List<String> cheeses = new ArrayList<>();
        List<String> regulars = new ArrayList<>();
        List<String> sauces = new ArrayList<>();

        for(Topping t : toppings) {
            String name = t.getName().toLowerCase();
            if (name.contains("chicken") || name.contains("steak") || name.contains("pork") || name.contains("shrimp")) {
                proteins.add(t.getName());
            } else if (name.contains("cheese")) {
                cheeses.add(t.getName());
            } else if (name.contains("salsa") || name.contains("sauce") || name.contains("cream")) {
                sauces.add(t.getName());
            } else {
                regulars.add(t.getName());
            }
        }
        if (!proteins.isEmpty()) desc.append("Protein: ").append(String.join(", ", proteins)).append("\n");
        if (!cheeses.isEmpty()) desc.append("Cheese: ").append(String.join(", ", cheeses)).append("\n");
        if (!regulars.isEmpty()) desc.append("Toppings: ").append(String.join(", ", regulars)).append("\n");
        if (!sauces.isEmpty()) desc.append("Sauces: ").append(String.join(", ", sauces)).append("\n");
        if (deepFried) desc.append("Deep Fried\n");

        return desc.toString();
    }
}

