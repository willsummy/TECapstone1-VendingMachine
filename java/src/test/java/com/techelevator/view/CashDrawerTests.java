package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class CashDrawerTests {

    @Test
    public void checks_money_input_and_correct_change() {
        CashDrawer testDrawer = new CashDrawer();
        testDrawer.addMoney(5);
        testDrawer.subtractPrice(1.05);
        double actual = testDrawer.getBalance();
        String actualString = testDrawer.returnChange();
        Assert.assertEquals(3.95, actual, 0);
        Assert.assertEquals("Your change is $3.95 in 15 Quarter(s), 2 Dime(s), and 0 Nickel(s).", actualString);
    }

    @Test
    public void change_not_divisible_by_5() {
        CashDrawer testDrawer = new CashDrawer();
        testDrawer.addMoney(10);
        testDrawer.subtractPrice(4.73);
        double actual = testDrawer.getBalance();
        String actualString = testDrawer.returnChange();
        Assert.assertEquals(5.27, actual, 0);
        Assert.assertEquals("Your change is $5.27 in 21 Quarter(s), 0 Dime(s), and 0 Nickel(s).", actualString);
    }

    @Test
    public void checks_money_input_and_correct_change_for_nickels() {
        CashDrawer testDrawer = new CashDrawer();
        testDrawer.addMoney(5);
        testDrawer.subtractPrice(1.95);
        double actual = testDrawer.getBalance();
        String actualString = testDrawer.returnChange();
        Assert.assertEquals(3.05, actual, 0);
        Assert.assertEquals("Your change is $3.05 in 12 Quarter(s), 0 Dime(s), and 1 Nickel(s).", actualString);
    }
}
