package com.techelevator.item;

import java.math.BigDecimal;

public abstract class Item {

    private final int TOTAL_ITEMS = 5;

    private String name;
    private BigDecimal price;
    private String slotLocation;
    private String soundMessage;
    private int itemsLeft;


    public Item(String name, BigDecimal price, String slotLocation) {
        this.name = name;
        this.price = price;
        this.slotLocation = slotLocation;
        itemsLeft = TOTAL_ITEMS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }

    public String getSoundMessage() {
        return soundMessage;
    }

    public void setSoundMessage(String soundMessage) {
        this.soundMessage = soundMessage;
    }

    public int getTotalItems() {
        return TOTAL_ITEMS;
    }

    public int getItemsLeft() {
        return itemsLeft;
    }

    public void setItemsLeft(int itemsLeft) {
        this.itemsLeft = itemsLeft;
    }


}