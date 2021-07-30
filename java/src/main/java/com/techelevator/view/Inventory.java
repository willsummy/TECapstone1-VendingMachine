package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {

    // attributes
    private Map<String, Integer> stockMap = new HashMap<>();
    private Map<String, Product> productMap = new HashMap<>();

    public Map<String, Integer> getStockMap() {
        return stockMap;
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public Inventory() {
        String filePath = "vendingmachine.csv";
        File inputFile = new File(filePath);

        // populate stockMap by default
        stockMap.put("A1", 5);
        stockMap.put("A2", 5);
        stockMap.put("A3", 5);
        stockMap.put("A4", 5);
        stockMap.put("B1", 5);
        stockMap.put("B2", 5);
        stockMap.put("B3", 5);
        stockMap.put("B4", 5);
        stockMap.put("C1", 5);
        stockMap.put("C2", 5);
        stockMap.put("C3", 5);
        stockMap.put("C4", 5);
        stockMap.put("D1", 5);
        stockMap.put("D2", 5);
        stockMap.put("D3", 5);
        stockMap.put("D4", 5);

        // populate productMap with vendingmachine.csv
        try {
            Scanner fileScanner = new Scanner(inputFile);
            while (fileScanner.hasNextLine()) {
                String currentLine = fileScanner.nextLine();
                String[] productInfo = currentLine.split("\\|");
                // info goes slotID, name, price, category
                String slotID = productInfo[0];
                String name = productInfo[1];
                Double price = Double.parseDouble(productInfo[2]);
                String category = productInfo[3];

                Product currentProduct = new Product(name, category, slotID, price);

                productMap.put(slotID, currentProduct);

            }




        } catch (FileNotFoundException e) {
            System.out.println("There was an error with vendingmachine.csv");
            e.printStackTrace();
        }



    }

    public double getProductPrice(String slotID) {
        return productMap.get(slotID).getPrice();
    }

    public boolean validateStock(String slotID) {
        if (stockMap.get(slotID) <= 0) {
            return false;
        } else {
            int currentStock = stockMap.get(slotID);
            currentStock--;
            stockMap.put(slotID, currentStock);
            return true;
        }
    }

    public String showItems() {
        // iterate through stock map
        // for every item, if stock is above 0
        // display product name, price, and slotID
        // return string to caller to sout menu
        String displayString = "";

        Set<String> keys = stockMap.keySet();

        List<String> orderedKeys = Arrays.asList(keys.toArray(new String[0]));
        orderedKeys.sort(null); // ordering keys for non random display

        for (int i = 0; i < orderedKeys.size(); i++) {
            String key = orderedKeys.get(i);
            if (stockMap.get(key) > 0) {
                // prints newline, then slotID name price
                displayString += "\n" + productMap.get(key).getSlotID() + " " + productMap.get(key).getName() + " $" + String.format("%.2f", productMap.get(key).getPrice()) + " |" + stockMap.get(key);
            }
        }
        return displayString;
    }



}
