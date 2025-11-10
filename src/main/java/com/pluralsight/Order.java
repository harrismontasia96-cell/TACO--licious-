package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) { items.add(item); }
    public void removeItem(MenuItem item) { items.remove(item); }
    public List<MenuItem> getItems() { return items; }

    public double calculateTotal() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public void displayOrder() {
        System.out.println("=== Your Order ===");
        for(MenuItem item : items) {
            System.out.println(item.getDescription() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

