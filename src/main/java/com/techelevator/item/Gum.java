package com.techelevator.item;

import java.math.BigDecimal;

import static com.techelevator.view.ColorsANSI.ANSI_CYAN;
import static com.techelevator.view.ColorsANSI.ANSI_RESET;

public class Gum extends Item{
    public Gum(String name, BigDecimal price, String slotLocation) {
        super(name, price, slotLocation);
        this.setSoundMessage(ANSI_CYAN + "Chew Chew, Yum!" + ANSI_RESET);
    }

    @Override
    public String getSoundFile() {
        return "src/main/resources/ChewChewYum.wav";
    }
}
