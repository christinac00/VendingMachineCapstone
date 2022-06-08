package com.techelevator.vendingmachine;

import com.techelevator.item.Candy;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class VendingMachineTest extends TestCase {

    @Test
    public void testAddMoney() {
        VendingMachine vendingMachine= new VendingMachine();
        vendingMachine.addMoney(new BigDecimal(10.00));
        assertEquals(vendingMachine.getCurrentMoney(), (new BigDecimal(10.00)));
        vendingMachine.addMoney(new BigDecimal(10.00));
        assertTrue(vendingMachine.getCurrentMoney().equals(new BigDecimal(20.00)));
    }

    @Test
    public void testGiveItem() {
        VendingMachine vendingMachine= new VendingMachine();
        Candy skittle = new Candy("skittle", new BigDecimal(1.00), "A2");
        vendingMachine.addItem(skittle);
        vendingMachine.addMoney(new BigDecimal(1.00));
        assertEquals(vendingMachine.giveItem("A2"), skittle);
    }

    @Test
    public void addItem() {
    }
}