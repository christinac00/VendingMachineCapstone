package com.techelevator.item;

import java.math.BigDecimal;

public class Chips extends Item{
    public Chips(String name, BigDecimal price, String slotLocation) {
        super(name, price, slotLocation);
        this.setSoundMessage("Crunch Crunch, Yum!");
    }
}
