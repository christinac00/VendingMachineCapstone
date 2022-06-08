package com.techelevator.fileaccessor;

import com.techelevator.item.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileAccessor {

    public static List<Item> getInventory(File file){
        List<Item> output = new ArrayList<>();
        try(
                Scanner input = new Scanner(file)
                ) {
            while(input.hasNext()){
                String inputItem = input.nextLine();

                String[] itemInfo = inputItem.split("//|");

                if(itemInfo[3].equals("Chip")){
                    output.add(new Chips(itemInfo[1], BigDecimal.valueOf(Double.parseDouble(itemInfo[2])), itemInfo[0]));
                } else if(itemInfo[3].equals("Candy")){
                    output.add(new Candy(itemInfo[1], BigDecimal.valueOf(Double.parseDouble(itemInfo[2])), itemInfo[0]));
                } else if(itemInfo[3].equals("Drink")){
                    output.add(new Beverage(itemInfo[1], BigDecimal.valueOf(Double.parseDouble(itemInfo[2])), itemInfo[0]));
                } else if(itemInfo[3].equals("Gum")){
                    output.add(new Gum(itemInfo[1], BigDecimal.valueOf(Double.parseDouble(itemInfo[2])), itemInfo[0]));
                }
            }
        } catch (FileNotFoundException e){
            System.err.println("File not found: " + e.getMessage());
        }
        return output;
    }


    public static boolean appendLog(){
        return false;
    }


}
