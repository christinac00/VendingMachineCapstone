package com.techelevator;

import com.techelevator.fileaccessor.FileAccessor;
import com.techelevator.vendingmachine.VendingMachine;
import com.techelevator.view.Menu;

import java.io.File;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachinePurchasing {

    private static final double QUARTER_VALUE = 0.25;
    private static final double DIME_VALUE = 0.10;
    private static final double NICKLE_VALUE = 0.05;

    private static final int QUARTER_LOCATION = 0;
    private static final int DIME_LOCATION = 1;
    private static final int NICKLE_LOCATION = 2;

    private static final String SUB_MENU_FEED_MONEY = "Feed Money";
    private static final String SUB_MENU_SELECT_PRODUCT = "Select Product";
    private static final String EXIT_SUB_MENU = "Finish Transaction";
    private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_FEED_MONEY, SUB_MENU_SELECT_PRODUCT, EXIT_SUB_MENU};

    private Menu menu;
    private VendingMachine vendingMachine;

    public VendingMachinePurchasing(Menu menu, VendingMachine vendingMachine) {
        this.menu = menu;
        this.vendingMachine = vendingMachine;
    }

    public void run() {

        File logFile = new File("Log.txt");
        Scanner userInput = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Current Money Added: $" + vendingMachine.getCurrentMoney().toString());

            String choice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);

            if (choice.equals(SUB_MENU_FEED_MONEY)) {
                System.out.println("Please enter amount of money you wish to add.");
                try{
                    BigDecimal addedMoney = BigDecimal.valueOf(Double.parseDouble(userInput.nextLine()));
                    vendingMachine.addMoney(addedMoney);
                    String message = " FEED MONEY: $" + addedMoney + " $" + vendingMachine.getCurrentMoney().toString();
                    FileAccessor.appendLog(logFile, message);
                } catch(NumberFormatException e){
                    System.out.println("Invalid format for adding money please try again!");
                }
            }
            else if (choice.equals(SUB_MENU_SELECT_PRODUCT)) {
                BigDecimal moneyAtStart = vendingMachine.getCurrentMoney();
                System.out.println("Please enter Product Slot Location.");
                String slotLocation = userInput.nextLine();
                try {
                    System.out.println(vendingMachine.giveItem(slotLocation).getSoundMessage());
                } catch (NullPointerException e){

                }
                if(vendingMachine.getInventory().get(slotLocation) != null && !moneyAtStart.equals(vendingMachine.getCurrentMoney())){
                    String message = " " + vendingMachine.getInventory().get(slotLocation).getName() + " " + slotLocation + " $" + vendingMachine.getInventory().get(slotLocation).getPrice() + " $" + vendingMachine.getCurrentMoney();
                    FileAccessor.appendLog(logFile, message);
                }
            }
            else if (choice.equals(EXIT_SUB_MENU)){
                String message = " GIVE CHANGE: $" + vendingMachine.getCurrentMoney() + " $0.00";
                FileAccessor.appendLog(logFile, message);
                String[] change = returnChange(vendingMachine.getCurrentMoney());
                System.out.println("Quarters returned: " + change[QUARTER_LOCATION] + "\nDimes returned: " + change[DIME_LOCATION] + "\nNickels returned: " + change[NICKLE_LOCATION]);
                vendingMachine.setCurrentMoney(BigDecimal.valueOf(0.0));
                isRunning = false;
            }
        }
    }

    private String[] returnChange(BigDecimal change){
        String[] output = new String[3];
        output[QUARTER_LOCATION] = change.divideAndRemainder(BigDecimal.valueOf(QUARTER_VALUE))[0].toBigInteger().toString();
        change = change.divideAndRemainder(BigDecimal.valueOf(QUARTER_VALUE))[1];

        output[DIME_LOCATION] = change.divideAndRemainder(BigDecimal.valueOf(DIME_VALUE))[0].toBigInteger().toString();
        change = change.divideAndRemainder(BigDecimal.valueOf(DIME_VALUE))[1];

        output[NICKLE_LOCATION] = change.divideAndRemainder(BigDecimal.valueOf(NICKLE_VALUE))[0].toBigInteger().toString();

        return output;
    }




}
