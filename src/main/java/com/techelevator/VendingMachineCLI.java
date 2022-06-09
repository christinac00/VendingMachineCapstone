package com.techelevator;

import com.techelevator.fileaccessor.FileAccessor;
import com.techelevator.vendingmachine.VendingMachine;
import com.techelevator.view.Menu;
import org.w3c.dom.ls.LSOutput;

import java.io.File;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String EXIT_PROGRAM = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, EXIT_PROGRAM };

	private Menu menu;
	private VendingMachine vendingMachine;

	private VendimgMachinePuchasing vendimgMachinePuchasing;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		vendingMachine = new VendingMachine(FileAccessor.getInventory(new File("vendingmachine.csv")));
		vendimgMachinePuchasing = new VendimgMachinePuchasing(menu, vendingMachine);
	}

	public void run() {

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				for( String key: vendingMachine.getInventory().keySet()){

					System.out.println(key + ": " + vendingMachine.getInventory().get(key));

				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				vendimgMachinePuchasing.run();
			} else if (choice.equals(EXIT_PROGRAM)){
				System.exit(1);
			}
		}
	}





	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}




