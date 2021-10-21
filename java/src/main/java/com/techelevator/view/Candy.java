package com.techelevator.view;

import java.math.BigDecimal;

public class Candy extends MenuItem {

    public Candy(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    @Override
    protected String getNoise() {
        return "Munch Munch, Yum!";
    }

}
