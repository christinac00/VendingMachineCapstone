package com.techelevator.item;

import java.math.BigDecimal;
public class Gum extends Item{
    public Gum(String name, BigDecimal price, String slotLocation) {
        super(name, price, slotLocation);
        this.setSoundMessage("Chew Chew, Yum!");
    }
}
