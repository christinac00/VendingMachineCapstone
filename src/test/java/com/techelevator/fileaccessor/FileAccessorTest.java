package com.techelevator.fileaccessor;

import com.techelevator.item.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileAccessorTest extends TestCase {

    @Test
    public void testGetInventory() {
        Map<String, Item> inventory = FileAccessor.getInventory(new File("vendingmachine.csv"));

        Map<String, Item> actualInventory = new TreeMap<>();
        actualInventory.put("A1", new Chips("Potato Crisps", BigDecimal.valueOf(3.05), "A1"));
        actualInventory.put("A2", new Chips("Stackers", BigDecimal.valueOf(1.45), "A2"));
        actualInventory.put("A3", new Chips("Grain Waves", BigDecimal.valueOf(2.75), "A3"));
        actualInventory.put("A4", new Chips("Cloud Popcorn", BigDecimal.valueOf(3.65), "A4"));

        actualInventory.put("B1", new Candy("Moonpie", BigDecimal.valueOf(1.80), "B1"));
        actualInventory.put("B2", new Candy("Cowtales", BigDecimal.valueOf(1.50), "B2"));
        actualInventory.put("B3", new Candy("Wonka Bar", BigDecimal.valueOf(1.50), "B3"));
        actualInventory.put("B4", new Candy("Crunchie", BigDecimal.valueOf(1.75), "B4"));

        actualInventory.put("C1", new Beverage("Cola", BigDecimal.valueOf(1.25), "C1"));
        actualInventory.put("C2", new Beverage("Dr. Salt", BigDecimal.valueOf(1.50), "C2"));
        actualInventory.put("C3", new Beverage("Mountain Melter", BigDecimal.valueOf(1.50), "C3"));
        actualInventory.put("C4", new Beverage("Heavy", BigDecimal.valueOf(1.50), "C4"));

        actualInventory.put("D1", new Gum("U-Chews", BigDecimal.valueOf(0.85), "D1"));
        actualInventory.put("D2", new Gum("Little League Chew", BigDecimal.valueOf(0.95), "D2"));
        actualInventory.put("D3", new Gum("Chiclets", BigDecimal.valueOf(0.75), "D3"));
        actualInventory.put("D4", new Gum("Triplemint", BigDecimal.valueOf(0.75), "D4"));


        boolean allEqual = true;
        for(String key : inventory.keySet()){
            if(!inventory.get(key).equals(actualInventory.get(key))){
                allEqual = false;
            }
        }

        assertTrue(allEqual);
    }
}