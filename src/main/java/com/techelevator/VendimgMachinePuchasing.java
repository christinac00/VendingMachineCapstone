package com.techelevator;

import com.techelevator.item.Item;
import com.techelevator.vendingmachine.VendingMachine;
import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendimgMachinePuchasing {

    private static final String SUB_MENU_FEED_MONEY = "Feed Money";
    private static final String SUB_MENU_SELECT_PRODUCT = "Select Product";
    private static final String EXIT_SUB_MENU = "Finish Transaction";
    private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_FEED_MONEY, SUB_MENU_SELECT_PRODUCT, EXIT_SUB_MENU};

    private Menu menu;
    private VendingMachine vendingMachine;

    public VendimgMachinePuchasing(Menu menu, VendingMachine vendingMachine) {
        this.menu = menu;
        this.vendingMachine = vendingMachine;
    }

    public void run() {

        Scanner userInput = new Scanner(System.in);
        List<Item> shoppingCart = new ArrayList<>();

        while (true) {
            System.out.println("Current Money Added: $" + vendingMachine.getCurrentMoney().toString());

            String choice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);

            if (choice.equals(SUB_MENU_FEED_MONEY)) {
                System.out.println("Please enter amount of money you wish to add.");
                try{
                    vendingMachine.addMoney(BigDecimal.valueOf(Double.parseDouble(userInput.nextLine())));
                } catch(NumberFormatException e){
                    System.out.println("Invalid format for adding money please try again!");
                }
            } else if (choice.equals(SUB_MENU_SELECT_PRODUCT)) {
                System.out.println("Please enter Product Slot Locaiton.");
                String slotLocation = userInput.nextLine();
                System.out.println(vendingMachine.giveItem(slotLocation).getSoundMessage());
            } else if (choice.equals(EXIT_SUB_MENU)){
                String[] change = returnChange(vendingMachine.getCurrentMoney());
                System.out.println("Quarters returned: " + change[0] + "\nDimes returned: " + change[1] + "\nNickels returned: " + change[2]);
                break;
            }
        }
    }

    private String[] returnChange(BigDecimal change){
        String[] output = new String[3];
        output[0] = change.divideAndRemainder(BigDecimal.valueOf(0.25))[0].toString();
        change = change.divideAndRemainder(BigDecimal.valueOf(0.25))[1];

        output[1] = change.divideAndRemainder(BigDecimal.valueOf(0.1))[0].toString();
        change = change.divideAndRemainder(BigDecimal.valueOf(0.1))[1];

        output[2] = change.divideAndRemainder(BigDecimal.valueOf(0.05))[0].toString();

        return output;
    }
}
