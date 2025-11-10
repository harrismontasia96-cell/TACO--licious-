package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Receipt {
    public static void save(Order order) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            File file = new File("receipts/" + timestamp + ".txt");
            file.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(file);
            for(MenuItem item : order.getItems()) {
                writer.write(item.getDescription() + " - $" + item.getPrice() + "\n");
            }
            writer.write("Total: $" + order.calculateTotal());
            writer.close();
            System.out.println("Receipt saved to " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
