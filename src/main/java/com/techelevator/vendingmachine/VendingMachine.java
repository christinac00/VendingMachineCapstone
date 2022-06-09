package com.techelevator.vendingmachine;

import com.techelevator.item.Item;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {

    private BigDecimal currentMoney;
    private BigDecimal totalMoney;
    private Map<String, Item> inventory;

    public VendingMachine() {
        currentMoney = new BigDecimal(0);
        totalMoney = new BigDecimal(0);
        inventory= new TreeMap<>();

    }

    public BigDecimal addMoney(BigDecimal moneyToBeAdded) {
        currentMoney= currentMoney.add(moneyToBeAdded);
        return currentMoney;
    }

    public Item giveItem(String slotLocation){
        Item output = inventory.get(slotLocation);

        if(output==null ){
            System.out.println("Item not found.");
        }

        else if( output.getItemsLeft() != 0 ){

            if(currentMoney.compareTo(output.getPrice()) >= 0){

                currentMoney= currentMoney.subtract(output.getPrice());
                totalMoney= totalMoney.add(output.getPrice());
                inventory.get(slotLocation).setItemsLeft(output.getItemsLeft()-1);

            }

            System.out.println("Not enough money!");


        }else {
            System.out.println("Item is SOLD OUT.");
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


}
