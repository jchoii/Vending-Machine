package com.techelevator.view;

import java.math.BigDecimal;

public class Drinks extends MenuItem {

    public Drinks(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    @Override
    protected String getNoise() {
        return "Glug Glug, Yum!";
    }

}
