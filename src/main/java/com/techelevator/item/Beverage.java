package com.techelevator.item;

import java.math.BigDecimal;

public class Beverage extends Item{

    public Beverage(String name, BigDecimal price, String slotLocation) {
        super(name, price, slotLocation);
        this.setSoundMessage("Glug Glug, Yum!");
    }
}
