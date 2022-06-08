package com.techelevator.item;

import java.math.BigDecimal;

public class Candy extends Item{
    public Candy(String name, BigDecimal price, String slotLocation) {
        super(name, price, slotLocation);
        this.setSoundMessage("Munch Munch, Yum!");
    }
}
