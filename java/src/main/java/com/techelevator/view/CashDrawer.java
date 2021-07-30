package com.techelevator.view;

public class CashDrawer {

    private double balance = 0.00;


    public CashDrawer() {}

    public void addMoney(double input) {
        if(input > 0) {
            this.balance += input;
        }
    }

    public boolean validatePrice(String slotID) {
        double price = Main.vendingMachine.getCurrentInventory().getProductPrice(slotID);
        return price <= balance;
    }

    public void subtractPrice(double price) {
        this.balance -= price;
    }

    public double getBalance() {
        this.balance = Math.round(this.balance * 100.0) / 100.0;
        return balance;
    }

    public String returnChange() {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        this.balance = Math.round(this.balance * 100.0) / 100.0;
        double printBalance = this.balance;

        while(this.balance >= .25) {
            quarters++;
            this.balance -= .25;
            this.balance = Math.round(this.balance * 100.0) / 100.0;
        }
        while(this.balance >= .10) {
            dimes++;
            this.balance -= .10;
            this.balance = Math.round(this.balance * 100.0) / 100.0;
        }
        while(this.balance >= .05) {
            nickels++;
            this.balance -= .05;
            this.balance = Math.round(this.balance * 100.0) / 100.0;
        }
        this.balance = 0;
        return "Your change is $" + String.format("%.2f", printBalance) + " in " + quarters + " Quarter(s), " + dimes + " Dime(s), and " + nickels + " Nickel(s).";
    }

}
