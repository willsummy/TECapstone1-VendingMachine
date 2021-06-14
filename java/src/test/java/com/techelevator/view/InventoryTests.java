package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class InventoryTests {
    @Test
    public void checks_product_price_returns_correct() {
        Inventory inventoryTest = new Inventory();
        double actual = inventoryTest.getProductPrice("A1");
        Assert.assertEquals(3.05, actual, 0);
    }

    @Test
    public void checks_validate_stock_returns_true() {
        Inventory inventoryTest = new Inventory();
        boolean actual = inventoryTest.validateStock("D4");
        Assert.assertTrue(actual);
    }

//    @Test
//    public void grabs_product_by_slotID() {
//        Inventory inventoryTest = new Inventory();
//        Product actual = inventoryTest.grabProduct("B3");
//        Assert.assertEquals("Wonka Bar", actual.getName());
//    }
}
