package by.gsu.epamlab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PurchaseList {

	List<Purchase> purchases;

	public PurchaseList() {
		super();
		purchases = new ArrayList<Purchase>();
	}

	public PurchaseList(File file) {
		super();
		this.purchases = new ArrayList<Purchase>();
		Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	private static Purchase getPurchase(Scanner sc) throws CsvLineException {
		String inputLine = sc.nextLine();
		String[] arguments = inputLine.split(Constants.LINE_DELIMTER);
		if (arguments.length != Constants.PURCHASE_INDECES
				&& arguments.length != Constants.DISCOUNT_PURCHASE_INDECES){
			throw new CsvLineException();
		}
		
		
			return null;

	}

}
