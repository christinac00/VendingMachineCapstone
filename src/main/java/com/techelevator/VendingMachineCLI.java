package com.techelevator;

import com.techelevator.fileaccessor.FileAccessor;
import com.techelevator.vendingmachine.VendingMachine;
import com.techelevator.view.Menu;

import java.io.File;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_SALES_REPORT = "Sales Report";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_SALES_REPORT};

	private Menu menu;
	private VendingMachine vendingMachine;
	private VendimgMachinePuchasing vendimgMachinePuchasing;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		vendingMachine = new VendingMachine(FileAccessor.getInventory(new File("vendingmachine.csv")));
		vendimgMachinePuchasing = new VendimgMachinePuchasing(menu, vendingMachine);
	}

	public void run() {

		Scanner userInput = new Scanner(System.in);

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				for( String key: vendingMachine.getInventory().keySet()){

					System.out.println(key + ":" + vendingMachine.getInventory().get(key));

				}



				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				vendimgMachinePuchasing.run();
			} else if(choice.equals(MAIN_MENU_OPTION_EXIT)){
				System.exit(1);
			}
			else if(choice.equals(MAIN_MENU_OPTION_SALES_REPORT)){
				System.out.println("the sales report");
			}
		}







	}





	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}




