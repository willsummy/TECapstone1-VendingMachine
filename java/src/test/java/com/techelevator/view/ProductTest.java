package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

    // constructor tests
    // call constructor with specific arguments and check equality
    @Test
    public void valid_constructor_check_name() {
        // arrange
        String expected = "Crunchy Chips";
        // act
        Product product = new Product("Crunchy Chips", "Chip", "G6", 9.00);
        String actual = product.getName();
        // assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valid_constructor_check_category() {
        // arrange
        String expected = "Chip";
        // act
        Product product = new Product("Crunchy Chips", "Chip", "G6", 9.00);
        String actual = product.getCategory();
        // assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void valid_constructor_check_slotID() {
        // arrange
        String expected = "G6";
        // act
        Product product = new Product("Crunchy Chips", "Chip", "G6", 9.00);
        String actual = product.getSlotID();
        // assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valid_constructor_check_price() {
        // arrange
        double expected = 9.00;
        // act
        Product product = new Product("Crunchy Chips", "Chip", "G6", 9.00);
        double actual = product.getPrice();
        // assert
        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void product_toString_chips() {
        // arrange
        String expected = "Crunch Crunch, Yum!";
        // act
        Product product = new Product("Crunchy Chips", "Chip", "G6", 9.00);
        String actual = product.toString();
        // assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void product_toString_candy() {
        // arrange
        String expected = "Munch Munch, Yum!";
        // act
        Product product = new Product("Mars Bar", "Candy", "G6", 9.00);
        String actual = product.toString();
        // assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void product_toString_drink() {
        // arrange
        String expected = "Glug Glug, Yum!";
        // act
        Product product = new Product("Fanta", "Drink", "G6", 9.00);
        String actual = product.toString();
        // assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void product_toString_gum() {
        // arrange
        String expected = "Chew Chew, Yum!";
        // act
        Product product = new Product("Yummy Gummy", "Gum", "G6", 9.00);
        String actual = product.toString();
        // assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void product_toString_unknown() {
        // arrange
        String expected = "Ew, what am I eating?";
        // act
        Product product = new Product("Nike", "Shoe", "G6", 9.00);
        String actual = product.toString();
        // assert
        Assert.assertEquals(expected, actual);
    }
}
