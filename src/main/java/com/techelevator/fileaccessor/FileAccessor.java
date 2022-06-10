package com.techelevator.fileaccessor;

import com.techelevator.VendimgMachinePuchasing;
import com.techelevator.item.*;
import com.techelevator.vendingmachine.VendingMachine;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileAccessor {

    private static final int ITEM_SLOT_LOCATION = 0;
    private static final int ITEM_NAME = 1;
    private static final int ITEM_PRICE = 2;
    private static final int ITEM_TYPE = 3;

    public static Map<String, Item> getInventory(File file){
        Map<String, Item> output = new TreeMap<>();
        try(
                Scanner input = new Scanner(file)
                ) {
            while(input.hasNext()){
                String inputItem = input.nextLine();

                String[] itemInfo = inputItem.split("\\|");

                if(itemInfo[ITEM_TYPE].equals("Chip")){
                    output.put(itemInfo[ITEM_SLOT_LOCATION] ,new Chips(itemInfo[ITEM_NAME], BigDecimal.valueOf(Double.parseDouble(itemInfo[ITEM_PRICE])), itemInfo[ITEM_SLOT_LOCATION]));
                } else if(itemInfo[ITEM_TYPE].equals("Candy")){
                    output.put(itemInfo[ITEM_SLOT_LOCATION], new Candy(itemInfo[ITEM_NAME], BigDecimal.valueOf(Double.parseDouble(itemInfo[ITEM_PRICE])), itemInfo[ITEM_SLOT_LOCATION]));
                } else if(itemInfo[ITEM_TYPE].equals("Drink")){
                    output.put(itemInfo[ITEM_SLOT_LOCATION], new Beverage(itemInfo[ITEM_NAME], BigDecimal.valueOf(Double.parseDouble(itemInfo[ITEM_PRICE])), itemInfo[ITEM_SLOT_LOCATION]));
                } else if(itemInfo[ITEM_TYPE].equals("Gum")){
                    output.put(itemInfo[ITEM_SLOT_LOCATION], new Gum(itemInfo[ITEM_NAME], BigDecimal.valueOf(Double.parseDouble(itemInfo[ITEM_PRICE])), itemInfo[ITEM_SLOT_LOCATION]));
                }
            }
        } catch (FileNotFoundException e){
            System.err.println("File not found: " + e.getMessage());
        }
        return output;
    }

    public static void appendLog(File file, String message){
        LocalDateTime currentDateTime = LocalDateTime.now();
        String formattedDate = currentDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));

        if(!file.exists()) {
            try {
                file.createNewFile();
            }
            catch(IOException e){
                System.out.println("ERROR, invalid!");
            }
        }

        try(PrintWriter output = new PrintWriter(new FileOutputStream(file, true))){
            output.println(formattedDate + message);
        }catch(FileNotFoundException e){
            System.out.println("ERROR, File not found!");
        }
    }

    public static void generateSalesReport(VendingMachine vendingMachine, String fileName) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        String formattedDate = currentDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm"));



        File salesReportFile = new File(formattedDate + " " + fileName);

        try{
            salesReportFile.createNewFile();
        } catch (IOException e){
            System.err.println("IO Exception: " + e.getMessage());
        }

        try(
                PrintWriter output = new PrintWriter(salesReportFile)
                ){
            for(String key : vendingMachine.getInventory().keySet()){
                output.println(vendingMachine.getInventory().get(key).amountSold());

            }

            output.println("**TOTAL SALES** " + vendingMachine.getTotalMoney());
        }catch(FileNotFoundException e){
            System.err.println("File not found: " + e.getMessage());
        }
    }


}
