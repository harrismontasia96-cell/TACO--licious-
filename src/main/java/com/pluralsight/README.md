# Tacolicious Java Project
This README summarizes key Java concepts, syntax, and object-oriented programming (OOP)
principles used in the Tacolicious Java Project.
Each section includes definitions, explanations, and examples drawn from the Taco App codebase.

## Table of Contents
* My Key Classes in My Taco App Include

Class Taco

Represents a single taco order with:

Size (SINGLE, THREE_TACO_PLATE, BURRITO)

Shell (CORN, FLOUR, HARD_SHELL, BOWL)

List of Topping objects

deepFried boolean

Methods include:

getPrice(): Calculates the price based on size, toppings, and deep fry option.

getDescription(): Generates a formatted description of the taco.

* Class Topping

Represents a single topping or sauce with:

name

isPremium (boolean)

price- Used to calculate additional costs for premium items.

* Class Order

Represents a full customer order. Contains:

List of MenuItem objects (Taco, Drink, ChipsAndSalsa)

# Methods:

addItem(), removeItem()

getTacoCount(), getNonTacoCount()

calculateTotal()

displayOrder()

getLastTaco(): Returns the last taco added to allow copying/customization

* Class TacoBuilder

Handles taco creation and customization:

buildTaco(): Guides user through selecting size, shell, toppings, sauces, and deep fry.

customizeExistingTaco(Taco Taco): Allows copying a previous taco and modifying it.

Private helper methods for selecting toppings, sauces, shell, and size.

*CLass Drink

Represents a beverage:

Size (SMALL, MEDIUM, LARGE)

flavor

Implements MenuItem with getPrice() and getDescription()

* class ChipsAndSalsa

Represents a chips and salsa order:

salsaType

Implements MenuItem

* Class Receipt

Handles saving or printing the final order.

# User Interaction

The main menu is in TacoApp

Users can:

Create new tacos

Add drinks

Add chips & salsa

Copy and customize previous tacos

Checkout and save order

## Java Concepts Used
// for Loop

Used to repeat a block of code a specific number of times.

Example in Taco App Class:
Iterating over toppings in the Taco class to calculate price and categorize them:

for(Topping t : toppings) {
if(t.isPremium()) price += t.getPrice();
}

//switch, case, and break

switch allows branching logic based on variable values.
case defines each branch, and break prevents fall-through.

Example in Taco App:
Selecting taco size in TacoBuilder Class:

switch (choice) {
case "1": return Taco.Size.SINGLE;
case "2": return Taco.Size.THREE_TACO_PLATE;
case "3": return Taco.Size.BURRITO;
default: return Taco.Size.SINGLE;
}

//Constructors

A constructor is a special method used to initialize new objects.
It has the same name as the class and no return type.

Example in Taco App Class:
Taco constructor:

public Taco(Size size, Shell shell, List<Topping> toppings, boolean deepFried) {
this.size = size;
this.shell = shell;
this.toppings = new ArrayList<>(toppings);
this.deepFried = deepFried;
}
Allows creating a new Taco object from an existing one:

public Taco(Taco other) {
this.shell = other.shell;
this.size = other.size;
this.deepFried = other.deepFried;
this.toppings = new ArrayList<>(other.toppings);
}


//this Keyword

Refers to the current instance of the class. Useful for distinguishing instance variables from parameters.

Example:

this.size = size;
this.shell = shell;


//Parameters

Variables passed into methods or constructors that act as inputs.
Parameters allow dynamic data to be passed into your methods.

Example:
buildTaco() receives size, shell, toppings, and deepFried values indirectly via user input.

//implements

Used when a class adopts an interface. Forces the class to define all methods declared in the interface.

Example:
Taco implements MenuItem interface:

public class Taco implements MenuItem {
@Override
public double getPrice() { ... }

    @Override
    public String getDescription() { ... }
}


//StringBuilder and append()

StringBuilder is used for mutable strings, allowing efficient modification.
append() adds text to the end of a string.

Example in Taco App:
Building a description of a Taco:

StringBuilder desc = new StringBuilder(size + " taco with " + shell + " shell\n");
desc.append("Protein: ").append(String.join(", ", proteins)).append("\n


// get Methods (Getters)

Used to retrieve the value of private variables. Part of encapsulation.

Example:

public List<Topping> getToppings() { return toppings; }
public Taco.Shell getShell() { return shell; }



// is Conventions

Boolean methods often start with is to indicate a true/false state.

Example:

public boolean isDeepFried() { return deepFried; }

 # Features Implemented

Object-oriented design with encapsulation and interfaces

Copy constructor for easy taco duplication

Toppings and sauces system with premium pricing

Deep fry option for tacos

Dynamic order system supporting tacos, drinks, and sides

Checkout with receipt generation

# Usage

Run TacoApp.java

Follow the console prompts to add tacos, drinks, or chips & salsa

Copy and customize previous tacos if desired

Checkout to save your order

# Explanation:

//*MenuItemCLASS is an interface that Taco, Drink, and ChipsAndSalsa implement.

//*TacoBuilderCLASS handles building or customizing tacos.

//*OrderCLASS manages a collection of MenuItems and tracks taco/non-taco items.

//*ReceiptCLASS handles saving/printing completed orders.

 ## Class Birthday ##

Represents a birthday party booking within the Taco App’s extended features.
This class adds an interactive experience that lets users plan a taco-themed birthday celebration
directly through the console interface.

# Key Responsibilities:

Collects party details from the user, including:

Date and time of the event

Name to be displayed on the personalized border sign

Piñata animal design and color selection

Example Method:

bookBirthdayParty()
Prompts the user for event details and customizations, returning a formatted summary of the birthday order.

Example Implementation:

public void bookBirthdayParty() {
System.out.print("Enter the date of the birthday party: ");
String date = scanner.nextLine();

    System.out.print("Enter the time of the birthday party: ");
    String time = scanner.nextLine();
    
    System.out.print("Enter the name to display on the birthday sign: ");
    String name = scanner.nextLine();
    
    System.out.print("Choose a piñata animal design: ");
    String animal = scanner.nextLine();
    
    System.out.print("Choose a color for the piñata: ");
    String color = scanner.nextLine();
    
    System.out.println("\n🎉 Birthday Party Booked!");
    System.out.println("Date: " + date);
    System.out.println("Time: " + time);
    System.out.println("Sign Name: " + name);
    System.out.println("Piñata: " + color + " " + animal);
}

* Integration with TacoApp:

The Birthday class is accessible from the main TacoApp menu, giving users
an additional option to plan a party alongside their food order.
It enhances the user experience by connecting custom taco catering packages
(Basic, Deluxe, or Premium) with birthday-specific decorations and activities.

* Java Concepts Demonstrated:

Encapsulation: Each party booking is self-contained, managed through the Birthday class.

User Input Handling: Uses Scanner to collect user input and dynamically build a summary.

String Concatenation: Outputs clear, formatted party details.

Method Invocation: Integrates seamlessly into the TacoApp’s existing flow
— called directly when the user selects the birthday booking option.