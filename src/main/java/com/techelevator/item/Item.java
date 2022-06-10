package com.techelevator.item;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return TOTAL_ITEMS == item.TOTAL_ITEMS && itemsLeft == item.itemsLeft && Objects.equals(name, item.name) && Objects.equals(price, item.price) && Objects.equals(slotLocation, item.slotLocation) && Objects.equals(soundMessage, item.soundMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TOTAL_ITEMS, name, price, slotLocation, soundMessage, itemsLeft);
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

    public String amountSold(){
        return name + "|" + (TOTAL_ITEMS-itemsLeft);
    }

    public abstract String getSoundFile();


    @Override
    public String toString() {
        return "name: " + name + " Price: " + price.toString() + " Amount Remaining: " + itemsLeft;
    }
}