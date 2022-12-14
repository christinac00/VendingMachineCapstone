package com.techelevator;

import com.techelevator.fileaccessor.FileAccessor;
import com.techelevator.vendingmachine.VendingMachine;
import com.techelevator.view.Menu;

import java.io.File;
import java.util.Scanner;

import static com.techelevator.view.ColorsANSI.ANSI_PURPLE;
import static com.techelevator.view.ColorsANSI.ANSI_RESET;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_SALES_REPORT = "Sales Report";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_SALES_REPORT};

	private Menu menu;
	private VendingMachine vendingMachine;
	private VendingMachinePurchasing vendingMachinePurchasing;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		vendingMachine = new VendingMachine(FileAccessor.getInventory(new File("vendingmachine.csv")));
		vendingMachinePurchasing = new VendingMachinePurchasing(menu, vendingMachine);
	}

	public void run() {

		Scanner userInput = new Scanner(System.in);

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				for( String key: vendingMachine.getInventory().keySet()){

					System.out.println(ANSI_PURPLE + key + ANSI_RESET + ":" + vendingMachine.getInventory().get(key));
				}


				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				vendingMachinePurchasing.run();
			} else if(choice.equals(MAIN_MENU_OPTION_EXIT)){
				System.exit(1);
			}
			else if(choice.equals(MAIN_MENU_OPTION_SALES_REPORT)){
				FileAccessor.generateSalesReport(vendingMachine, "SalesReport.txt");
			}
		}







	}





	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}




