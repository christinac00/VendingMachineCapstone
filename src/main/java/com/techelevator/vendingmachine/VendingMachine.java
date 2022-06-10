package com.techelevator.vendingmachine;

import com.techelevator.item.Item;
import com.techelevator.view.AudioPlayer;
import com.techelevator.view.ColorsANSI;

import java.io.File;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import static com.techelevator.view.ColorsANSI.ANSI_RED;
import static com.techelevator.view.ColorsANSI.ANSI_RESET;
import static java.awt.PageAttributes.MediaType.D;

public class VendingMachine {

    private BigDecimal currentMoney;
    private BigDecimal totalMoney;
    private Map<String, Item> inventory;
    public ColorsANSI colorsANSI;

    public VendingMachine(Map<String, Item> inventory) {
        currentMoney = new BigDecimal(0);
        totalMoney = new BigDecimal(0);
        this.inventory = inventory;
    }

    public BigDecimal addMoney(BigDecimal moneyToBeAdded) {
        currentMoney= currentMoney.add(moneyToBeAdded);
        return currentMoney;
    }

    public Item giveItem(String slotLocation){
        Item output = inventory.get(slotLocation);

        if(output==null ){
            System.out.println(ANSI_RED + "Item not found." + ANSI_RESET);
        }

        else if( output.getItemsLeft() != 0 ){

            if(currentMoney.compareTo(output.getPrice()) >= 0){

                currentMoney= currentMoney.subtract(output.getPrice());
                totalMoney= totalMoney.add(output.getPrice());
                inventory.get(slotLocation).setItemsLeft(output.getItemsLeft()-1);

            } else {
                System.out.println(ANSI_RED + "Not enough money!"+ ANSI_RESET);
                output = null;
            }

        }else {
            System.out.println(ANSI_RED +"Item is SOLD OUT."+ ANSI_RESET);
            output = null;
        }
        return output;
    }

    public void addItem(Item item){
        inventory.put(item.getSlotLocation(), item);
    }

    public BigDecimal getCurrentMoney() {
        return currentMoney;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public Map<String, Item> getInventory() {
        return inventory;
    }

    public void setCurrentMoney(BigDecimal currentMoney){
        this.currentMoney = currentMoney;
    }


}
