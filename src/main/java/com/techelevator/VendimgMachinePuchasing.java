package com.techelevator;

import com.techelevator.vendingmachine.VendingMachine;
import com.techelevator.view.Menu;

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

        while (true) {
            String choice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);

            if (choice.equals(SUB_MENU_FEED_MONEY)) {

            } else if (choice.equals(SUB_MENU_SELECT_PRODUCT)) {
                // do purchase
            } else if (choice.equals(EXIT_SUB_MENU)){
                break;
            }
        }
    }
}
