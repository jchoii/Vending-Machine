package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineTest {

    private VendingMachine vm2;

    @Before
    public void setup() {
        vm2 = new VendingMachine();
    }

    @Test
    public void test_stock_inventory(){
        int originalMenuSize = vm2.getMenuChoices().entrySet().size();
        vm2.stockInventory();
        int newMenuSize = vm2.getMenuChoices().entrySet().size();
        Assert.assertEquals(0, originalMenuSize);
        Assert.assertEquals(16, newMenuSize);
    }

    @Test
    public void test_add_balance() {
        vm2.addBalance(new BigDecimal(5.25));
        Assert.assertEquals(new BigDecimal(5.25), vm2.getBalance());
    }

    @Test
    public void test_is_valid_slot_true(){
        vm2.stockInventory();
        boolean result = vm2.isValidSlot("A1");
        Assert.assertTrue(result);
    }

    @Test
    public void test_is_valid_slot_false(){
        vm2.stockInventory();
        boolean result = vm2.isValidSlot("Z5");
        Assert.assertFalse(result);
    }

    @Test
    public void test_purchase_item_insufficient_fund() {
        vm2.stockInventory();
       String result = vm2.purchaseItem("A1");
        Assert.assertEquals("Insufficient Funds. Please insert more money.", result);
    }

    @Test
    public void test_purchase_item_sufficient_fund() {
        vm2.stockInventory();
        vm2.addBalance(new BigDecimal(5));
        String result = vm2.purchaseItem("A1");
        Assert.assertEquals("Crunch Crunch, Yum!", result);
    }

    @Test
    public void test_purchase_item_does_not_exist() {
        vm2.addBalance(new BigDecimal(5));
        String result = vm2.purchaseItem("Z9");
        Assert.assertEquals("Item Does Not Exist", result);
    }

    @Test
    public void test_purchase_item_sold_out() {
        vm2.stockInventory();
        vm2.addBalance(new BigDecimal(10));
        vm2.getMenuChoices().get("A1").setInventory(0);
        String result = vm2.purchaseItem("A1");
        Assert.assertEquals("SOLD OUT", result);
    }

     @Test
    public void test_balance_update_return_balance() {
        vm2.stockInventory();
        vm2.addBalance(new BigDecimal(5.05));
        vm2.purchaseItem("A1");
        BigDecimal result = vm2.balanceUpdate("A1");
        result = result.setScale(0, RoundingMode.CEILING);
        Assert.assertEquals(new BigDecimal(2), result);
    }

    @Test
    public void test_return_change_quarters() {
        vm2.addBalance(new BigDecimal(1.00));
        String result = vm2.returnChange();
        Assert.assertEquals("Your change is: 4 quarters, 0 dimes, 0 nickel", result);
    }

    @Test
    public void
    test_return_change_nickel() {
        vm2.addBalance(new BigDecimal(1.15));
        String result = vm2.returnChange();
        Assert.assertEquals("Your change is: 4 quarters, 1 dimes, 1 nickel", result);
    }

    @Test
    public void test_purchase_audit_exception(){
        vm2.setFileName("");
        vm2.purchaseAudit("", new BigDecimal(0), new BigDecimal(0));
        Assert.assertTrue(true);
    }
}
