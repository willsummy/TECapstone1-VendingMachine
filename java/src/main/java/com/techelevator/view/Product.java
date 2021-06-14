package com.techelevator.view;

public class Product {

    private String name;
    private String category;
    private String slotID;
    private double price;

    public Product(String name, String category, String slotID, double price) {
        this.name = name;
        this.category = category;
        this.slotID = slotID;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getSlotID() {
        return slotID;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String sound = "";
        if(this.category.equals("Chip")) {
            sound = "Crunch Crunch, Yum!";
        } else if(this.category.equals("Candy")) {
            sound = "Munch Munch, Yum!";
        } else if(this.category.equals("Gum")) {
            sound = "Chew Chew, Yum!";
        } else if(this.category.equals("Drink")) {
            sound = "Glug Glug, Yum!";
        } else {
            sound = "Ew, what am I eating?";
        }
        return sound;
    }

    /*
    name
    category
    slotID
    price

    Product(String name, String category, String slotID, double price) {
        blah blah

    }

    getters...


    toString() {
        if chip
            sout "Crunch Crunch, Yum!"
        else if candy
            sout  "Munch Munch, Yum!"
        else if gum
            sout  "Chew Chew, Yum!"
        else if drink
            sout "Glug Glug, Yum!"
    }



     */


}
