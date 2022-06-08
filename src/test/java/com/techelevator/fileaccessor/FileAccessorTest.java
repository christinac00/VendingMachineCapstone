package com.techelevator.fileaccessor;

import com.techelevator.item.Item;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class FileAccessorTest extends TestCase {

    @Test
    public void testGetInventory() {
        List<Item> inventory = FileAccessor.getInventory(new File("vendingmachine.csv"));
    }
}