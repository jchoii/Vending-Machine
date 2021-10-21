package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class DrinksTest {

    private Drinks drinks;

    @Before
    public void setup() {
        drinks = new Drinks("","", new BigDecimal(0));
    }

    @Test
    public void test_get_noise(){
        String result = drinks.getNoise();
        Assert.assertEquals("Glug Glug, Yum!", result);
    }

}
