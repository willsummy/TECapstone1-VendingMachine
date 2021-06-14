package com.techelevator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Key;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VendingMachine {

    private Inventory currentInventory = new Inventory();
    private CashDrawer currentDrawer = new CashDrawer();
    private UserInterface UI = new UserInterface();
    private Map<String, Integer> tempReport = new HashMap<>() {{
        put("Potato Crisps", 0);
        put("Stackers", 0);
        put("Grain Waves", 0);
        put("Cloud Popcorn", 0);
        put("Moonpie", 0);
        put("Cowtales", 0);
        put("Wonka Bar", 0);
        put("Crunchie", 0);
        put("Cola", 0);
        put("Dr. Salt", 0);
        put("Mountain Melter", 0);
        put("Heavy", 0);
        put("U-Chews", 0);
        put("Little League Chew", 0);
        put("Chiclets", 0);
        put("Triplemint", 0);
    }}; //could have made a separate method for reading the input file then called that method to receive the product names or
    // even went through product map and did a toString on products



    public Inventory getCurrentInventory() {
        return currentInventory;
    }

    public CashDrawer getCurrentDrawer() {
        return currentDrawer;
    }

    public UserInterface getUI() {
        return UI;
    }

    public void audit(double originalBalance, double updatedBalance, String type) {
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        String dateAndTime = dateTime.format(LocalDateTime.now());
        File auditLog = new File("src/main/resources/log.txt");
        try(FileWriter writer = new FileWriter(auditLog, true)) {
            if(!auditLog.exists()) {
                auditLog.createNewFile();
            }
            writer.write(dateAndTime + " " + type + " $" + originalBalance + " $" + updatedBalance + "\n");
        } catch(IOException e) {
            System.err.println("Audit Log not created");
        }


    }

    public void tempSalesReport(Product name, Map<String, Product> productList) {
        Set<String> keys = productList.keySet();

        Set<String> productKeys = tempReport.keySet();
        for (String productKey : productKeys) {
            if (productKey.equals(name.getName())) {
                int count = tempReport.get(productKey);
                count++;
                tempReport.put(productKey, count);
            }
        }
    }



    public void finalSalesReport() {
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("MMddyyyy_HHmm");
        String dateAndTime = dateTime.format(LocalDateTime.now());
        String fileName = "src/main/resources/" + dateAndTime + "_salesReport.txt";
        Set<String> productKeys = tempReport.keySet();
        File salesReport = new File(fileName);
        try(PrintWriter writer = new PrintWriter(salesReport)) {
            if(!salesReport.exists()) {
                salesReport.createNewFile();
            }
            for(String product : productKeys) {
                writer.println(product + " | " + tempReport.get(product));
            }
        } catch(IOException e) {
            System.err.println("Sales Report not created");
        }
    }

//    File tempReport = new File("tempReport.txt");
//        try(FileWriter writer = new FileWriter(tempReport, true)) {
//            Scanner fileReader = new Scanner(tempReport);
//            if (!tempReport.exists()) {
//                tempReport.createNewFile();
//                for(String key : keys) {
//                    writer.write(productList.get(key).getName() + "\\|" + 0);
//                }
//            }
//            while(fileReader.hasNextLine()){
//                if(fileReader.nextLine().contains(name.toString())) {
//                    String[] lineWords = fileReader.nextLine().split("\\|");
//                    int productCount = Integer.parseInt(lineWords[lineWords.length - 1]);
//                    productCount++;
//                    lineWords[lineWords.length - 1] = String.valueOf(productCount);
//                }
//            }
//        } catch(IOException e) {
//            System.err.println("Audit Log not created");
//        }




    /* attributes
     * Inventory currentInventory = new Inventory;
     * CashDrawer currentDrawer = new CashDrawer;
     * UserInterface ui = new UserInterface;
     */

    /* constructor
    *
    *
     */

    /* methods
    *
    * finalSalesReport
    *   create new file, of current days purchase log.txt
    *   named date and time
    *   write sales report to file
    *
    * purchaseAudit
    *   every successful purchase writes to log.txt with date, time, feed money, purchase money
    *   look at README example
    *
     */

    // run UI method

}
