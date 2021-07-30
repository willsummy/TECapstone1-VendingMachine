package com.techelevator.view;


import java.util.Map;
import java.util.Scanner;

public class UserInterface {


    public void run() {

        Scanner userInput = new Scanner(System.in);

        while (true) {

            // main menu
            System.out.println( "Main Menu \n" +
                    "(1) Display Vending Machine Items \n" +
                    "(2) Purchase \n" +
                    "(3) Exit \n"
            );

            // user choice
            System.out.print("What would you like to do? ");
            String userChoice = userInput.nextLine();
            int mainChoice; // input as an integer

            // checking if input is an integer
            try {
                mainChoice = Integer.parseInt(userChoice);
            } catch (Exception e) {
                System.out.println("That was not a valid choice. \n");
                continue;
            }

            // validating 1-4
            if (mainChoice < 1 || mainChoice > 4) {
                System.out.println("Not a valid input. \n");
                continue;
            }

            // choices brances
            if (mainChoice == 1) {
                // display items
                System.out.println(Main.vendingMachine.getCurrentInventory().showItems());
                System.out.println();
                continue;


            } else if (mainChoice == 2) {
                // purchase menu
                System.out.println();
                purchaseMenu();

                continue;

            } else if (mainChoice == 3) {
                // exit
                System.out.println("Goodbye!");
                System.exit(1);
            } else if (mainChoice == 4) {
                // sales report
                Main.vendingMachine.finalSalesReport();

            } else {
                System.out.println("That was not a valid choice. \n");
                continue;
            }





            break;
        }


    }

    public void purchaseMenu() {

        Scanner userInput = new Scanner(System.in);

        while (true) {

            double currentMoney = Main.vendingMachine.getCurrentDrawer().getBalance();
            double startingBalance = currentMoney;

            System.out.println("Purchase Menu \n" +
                    "(1) Feed Money \n" +
                    "(2) Select Product \n" +
                    "(3) Finish Transaction \n" +
                    "\n" +
                    "Current Money Provided: $" + String.format("%.2f", startingBalance) + "\n"
            );

            System.out.print("What would you like to do? ");
            String userChoice = userInput.nextLine();
            System.out.println();
            int purchaseChoice = 0;

            // checking for int input
            try {
                purchaseChoice = Integer.parseInt(userChoice);
            } catch (Exception e) {
                System.out.println("Not a valid input. \n");
                continue;
            }

            // checking if its 1, 2, 3
            if (purchaseChoice < 1 || purchaseChoice > 3) {
                System.out.println("Not a valid input. \n");
                continue;
            }

            if (purchaseChoice == 1) {
                // feed money
                System.out.print("How much would you like to add? (Please use whole integers) ");
                int inputMoney;
                double originalBalance = currentMoney;

                // validates input as int
                try {
                    inputMoney = Integer.parseInt(userInput.nextLine());
                } catch (Exception e) {
                    System.out.println("Please enter 1, 2, 5, 10, or 20. \n");
                    continue;
                }

                // validates input as positive
                if (inputMoney < 1) {
                    System.out.println("Please enter 1, 2, 5, 10, or 20. \n");
                    continue;
                }

                // validating input as 1, 2, 5, 10, 20
                if (inputMoney == 1 || inputMoney == 2 || inputMoney == 5 || inputMoney == 10 || inputMoney == 20) {
                    Main.vendingMachine.getCurrentDrawer().addMoney(inputMoney);
                    System.out.println("Added " + inputMoney + " to balance! \n");
                    currentMoney = Main.vendingMachine.getCurrentDrawer().getBalance();

                    // audit log
                    Main.vendingMachine.audit(originalBalance, currentMoney, "FEED MONEY:");

                    continue;
                } else {
                    System.out.println("Please enter 1, 2, 5, 10, or 20. \n");
                    continue;
                }


            } else if (purchaseChoice == 2) {
                // select product
                System.out.println("Which item would you like to purchase?");
                System.out.println(Main.vendingMachine.getCurrentInventory().showItems());
                System.out.println();
                System.out.print("Enter the Slot ID (ex. A4) ");
                String slotInput = userInput.nextLine().toUpperCase();

                // storing stuff for easier use
                Inventory inv = Main.vendingMachine.getCurrentInventory();
                CashDrawer drawer = Main.vendingMachine.getCurrentDrawer();
                currentMoney = Main.vendingMachine.getCurrentDrawer().getBalance();
                double originalBalance = currentMoney;

                // validate input
                if (!inv.getStockMap().containsKey(slotInput)) {
                    // if stockMap in Inventory does not have slot identified by input
                    System.out.println("Not a valid slot ID \n");
                    continue;
                } else {

                    if (!drawer.validatePrice(slotInput)) {
                        System.out.println("\n Not enough money! \n");
                        continue;
                    } else if (!inv.validateStock(slotInput)) {
                        System.out.println("\n Product is out of stock! \n");
                        continue;
                    } else {
                        Product currentProduct = inv.getProductMap().get(slotInput);
                        drawer.subtractPrice(currentProduct.getPrice());
                        System.out.println("\n Successful purchase! \n");
                        System.out.println(currentProduct.getName() + " Price: $" + String.format("%.2f", currentProduct.getPrice()) + " Balance: $" + String.format("%.2f", drawer.getBalance()));
                        System.out.println(currentProduct); // custom toString
                        System.out.println();

                        // audit
                        currentMoney = Main.vendingMachine.getCurrentDrawer().getBalance();
                        Main.vendingMachine.audit(originalBalance, currentMoney, currentProduct.getName() + " " + currentProduct.getSlotID());

                        // temp sales report add
                        Map<String, Product> pMap = inv.getProductMap();
                        Main.vendingMachine.tempSalesReport(currentProduct, pMap);


                    }
                }

                continue;

            } else if (purchaseChoice == 3) {
                currentMoney = Main.vendingMachine.getCurrentDrawer().getBalance();
                double originalBalance = currentMoney;

                CashDrawer drawer = Main.vendingMachine.getCurrentDrawer();
                System.out.println("Returning change! \n");
                String change = drawer.returnChange();
                System.out.println(change);
                System.out.println();

                // audit log
                currentMoney = Main.vendingMachine.getCurrentDrawer().getBalance();
                Main.vendingMachine.audit(originalBalance, currentMoney, "GIVE CHANGE:");

                return;
            }


            return;
        }


    }

}
