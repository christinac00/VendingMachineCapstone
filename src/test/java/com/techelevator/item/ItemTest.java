package com.techelevator.item;

import junit.framework.TestCase;

import static org.junit.Assert.*;
import com.techelevator.item.*;
import org.junit.Test;

import java.math.BigDecimal;


public class ItemTest extends TestCase {

    @Test
    public void testBeverageConstructor(){
        Beverage beverage = new Beverage("Coke", new BigDecimal(1.00), "A1");

        assertTrue(beverage.getSoundMessage().equals("Glug Glug, Yum!"));
    }

    @Test
    public void testChipsConstructor(){
        Chips chips = new Chips("Lays", new BigDecimal(1.0), "A1");

        assertTrue(chips.getSoundMessage().equals("Crunch Crunch, Yum!"));
    }

    @Test
    public void testGumConstructor(){
        Gum gum = new Gum("Big League Chew", new BigDecimal(1.00), "A1");

        assertTrue(gum.getSoundMessage().equals("Chew Chew, Yum!"));
    }

    @Test
    public void testCandyConstructor(){
        Candy candy = new Candy("Twix", new BigDecimal(1.00), "A1");

        assertTrue(candy.getSoundMessage().equals("Munch Munch, Yum!"));
    }

}