package com.techelevator.fileaccessor;

import com.techelevator.item.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class FileAccessor {

    public static Map<String, Item> getInventory(File file){
        Map<String, Item> output = new TreeMap<>();
        try(
                Scanner input = new Scanner(file)
                ) {
            while(input.hasNext()){
                String inputItem = input.nextLine();

                String[] itemInfo = inputItem.split("\\|");

                if(itemInfo[3].equals("Chip")){
                    output.put( itemInfo[0] ,new Chips(itemInfo[1], BigDecimal.valueOf(Double.parseDouble(itemInfo[2])), itemInfo[0]));
                } else if(itemInfo[3].equals("Candy")){
                    output.put(itemInfo[0], new Candy(itemInfo[1], BigDecimal.valueOf(Double.parseDouble(itemInfo[2])), itemInfo[0]));
                } else if(itemInfo[3].equals("Drink")){
                    output.put(itemInfo[0], new Beverage(itemInfo[1], BigDecimal.valueOf(Double.parseDouble(itemInfo[2])), itemInfo[0]));
                } else if(itemInfo[3].equals("Gum")){
                    output.put(itemInfo[0], new Gum(itemInfo[1], BigDecimal.valueOf(Double.parseDouble(itemInfo[2])), itemInfo[0]));
                }
            }
        } catch (FileNotFoundException e){
            System.err.println("File not found: " + e.getMessage());
        }
        return output;
    }


    public static boolean appendLog(File file){

        if(!file.exists()) {
            try {
                file.createNewFile();
            }
            catch(IOException e){
                System.out.println("ERROR, invalid!");
            }
        }

        try(PrintWriter output = new PrintWriter(new FileOutputStream(file, true))){
            output.println();
        }catch(FileNotFoundException e){

        }

        return false;
    }


}
