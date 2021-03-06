package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class MenuItemTest {

    private Candy candy;
    private VendingMachine vm;

    @Before
    public void setup() {
        candy = new Candy("", "", new BigDecimal(0));
        vm = new VendingMachine();
    }

    @Test
    public void test_set_name() {
        candy.setName("test");
        Assert.assertEquals("test", candy.getName());
    }

    @Test
    public void test_dispense_item_not_sold_out() {
        vm.stockInventory();
        String result = candy.dispenseItem();
        Assert.assertEquals("Munch Munch, Yum!", result);
        Assert.assertEquals(4, candy.getInventory());
    }

    @Test
    public void test_dispense_item_sold_out() {
        candy.setInventory(0);
        String result = candy.dispenseItem();
        Assert.assertEquals("SOLD OUT", result);
    }

    @Test
    public void test_get_noise(){
        String result = candy.getNoise();
        Assert.assertEquals("Munch Munch, Yum!", result);
    }

}
