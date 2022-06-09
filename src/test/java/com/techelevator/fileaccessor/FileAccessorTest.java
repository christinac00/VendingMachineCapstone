package com.techelevator.fileaccessor;

import com.techelevator.item.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FileAccessorTest extends TestCase {

    @Test
    public void testGetInventory() {
        List<Item> inventory = FileAccessor.getInventory(new File("vendingmachine.csv"));

        List<Item> actualInventory = new ArrayList<>();
        actualInventory.add(new Chips("Potato Crisps", BigDecimal.valueOf(3.05), "A1"));
        actualInventory.add(new Chips("Stacker", BigDecimal.valueOf(1.45), "A2"));
        actualInventory.add(new Chips("Grain Waves", BigDecimal.valueOf(2.75), "A3"));
        actualInventory.add(new Chips("Cloud Popcorn", BigDecimal.valueOf(3.65), "A4"));

        actualInventory.add(new Candy("MoonPie", BigDecimal.valueOf(1.80), "B1"));
        actualInventory.add(new Candy("Cowtales", BigDecimal.valueOf(1.50), "B2"));
        actualInventory.add(new Candy("Wonka Bar", BigDecimal.valueOf(1.50), "B3"));
        actualInventory.add(new Candy("Crunchie", BigDecimal.valueOf(1.75), "B4"));

        actualInventory.add(new Beverage("Cola", BigDecimal.valueOf(1.25), "C1"));
        actualInventory.add(new Beverage("Dr. Salt", BigDecimal.valueOf(1.50), "C2"));
        actualInventory.add(new Beverage("Mountain Melter", BigDecimal.valueOf(1.50), "C3"));
        actualInventory.add(new Beverage("Heavy", BigDecimal.valueOf(1.50), "C4"));

        actualInventory.add(new Gum("U-Chews", BigDecimal.valueOf(0.85), "D1"));
        actualInventory.add(new Gum("Little League Chew", BigDecimal.valueOf(0.95), "D2"));
        actualInventory.add(new Gum("Chiclets", BigDecimal.valueOf(0.75), "D3"));
        actualInventory.add(new Gum("Triplemint", BigDecimal.valueOf(0.75), "D4"));


        boolean allEqual = true;
        for(int i = 0; i < inventory.size(); i++){
            if(!inventory.get(i).equals(actualInventory.get(i))){
                allEqual = false;
            }
        }

        assertTrue(allEqual);
    }
}