package com.techelevator.item;

import java.math.BigDecimal;

import static com.techelevator.view.ColorsANSI.ANSI_CYAN;
import static com.techelevator.view.ColorsANSI.ANSI_RESET;

public class Beverage extends Item{

    public Beverage(String name, BigDecimal price, String slotLocation) {
        super(name, price, slotLocation);
        this.setSoundMessage(ANSI_CYAN + "Glug Glug, Yum!" + ANSI_RESET);
    }

    @Override
    public String getSoundFile() {
        return "src/main/resources/GlugGlugYum.wav";
    }
}
