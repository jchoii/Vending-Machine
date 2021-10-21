package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ChipsTest {

    private Chips chips;

    @Before
    public void setup(){
        chips = new Chips("", "", new BigDecimal(0));
    }

    @Test
    public void test_get_noise() {
        String result = chips.getNoise();
        Assert.assertEquals("Crunch Crunch, Yum!", result);
    }

}