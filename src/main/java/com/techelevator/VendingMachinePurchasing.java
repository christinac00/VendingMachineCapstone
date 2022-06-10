package com.techelevator;

import com.techelevator.fileaccessor.FileAccessor;
import com.techelevator.vendingmachine.VendingMachine;
import com.techelevator.view.AudioPlayer;
import com.techelevator.view.Menu;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import static com.techelevator.view.ColorsANSI.*;

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
            System.out.println("Current Money Added: $" + ANSI_GREEN + vendingMachine.getCurrentMoney().toString() + ANSI_RESET);

            String choice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);

            if (choice.equals(SUB_MENU_FEED_MONEY)) {
                System.out.println("Please enter amount of money you wish to add.");
                try{
                    BigDecimal addedMoney = BigDecimal.valueOf(Double.parseDouble(userInput.nextLine()));
                    vendingMachine.addMoney(addedMoney);
                    String message = " FEED MONEY: $" + addedMoney + " $" + vendingMachine.getCurrentMoney().toString();
                    FileAccessor.appendLog(logFile, message);
                } catch(NumberFormatException e){
                    System.out.println(ANSI_RED + "Invalid format for adding money please try again!" + ANSI_RESET);
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
                    try(
                            AudioPlayer audioPlayer = new AudioPlayer(new File(vendingMachine.getInventory().get(slotLocation).getSoundFile()));
                            ) {
                        audioPlayer.play();
                    } catch (UnsupportedAudioFileException e) {
                        System.out.println(ANSI_RED + "Unsupported Audio File" + ANSI_RESET);
                    } catch (LineUnavailableException e) {
                        System.out.println(ANSI_RED + "Line Unavailable" + ANSI_RESET);
                    } catch (IOException e) {
                        System.out.println(ANSI_RED + "Input Output Error" + ANSI_RESET);
                    }
                    String message = " " + vendingMachine.getInventory().get(slotLocation).getName() + " " + slotLocation + " $" + vendingMachine.getInventory().get(slotLocation).getPrice() + " $" + vendingMachine.getCurrentMoney();
                    FileAccessor.appendLog(logFile, message);
                }
            }
            else if (choice.equals(EXIT_SUB_MENU)){
                String message = " GIVE CHANGE: $" + vendingMachine.getCurrentMoney() + " $0.00";
                FileAccessor.appendLog(logFile, message);
                String[] change = returnChange(vendingMachine.getCurrentMoney());
                System.out.println("Quarters returned: " + ANSI_GREEN + change[QUARTER_LOCATION] + ANSI_RESET + "\nDimes returned: " + ANSI_GREEN + change[DIME_LOCATION] + ANSI_RESET + "\nNickels returned: " + ANSI_GREEN + change[NICKLE_LOCATION] + ANSI_RESET);
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
