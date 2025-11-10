package com.pluralsight;

public class ChipsAndSalsa implements MenuItem{
    private String salsaType;

    public ChipsAndSalsa(String salsaType) {
        this.salsaType = salsaType;
    }

    @Override
    public double getPrice() { return 3.0; }

    @Override
    public String getDescription() { return "Chips & " + salsaType + " salsa"; }
}

