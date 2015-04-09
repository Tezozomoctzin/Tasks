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
		Scanner input = null;
		try {
			input = new Scanner(file);
			purchases = getPurchases(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (WrongCsvException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}

	private static Purchase getPurchase(Scanner sc) throws CsvLineException {
		String inputLine = sc.nextLine();
		String[] arguments = inputLine.split(Constants.LINE_DELIMTER);
		if (arguments.length != Constants.PURCHASE_INDECES
				&& arguments.length != Constants.DISCOUNT_PURCHASE_INDECES) {
			throw new CsvLineException();
		}
		try {
			int inputPrice = Integer.parseInt(arguments[Constants.PRICE_INDEX]);
			int inputNumber = Integer
					.parseInt(arguments[Constants.NUMBER_INDEX]);
			if (arguments.length == Constants.DISCOUNT_PURCHASE_INDECES) {
				int inputDiscount = Integer
						.parseInt(arguments[Constants.DISCOUNT_INDEX]);
			}
			return PurchaseFactory.getPurchaseFromFactory(arguments);
		} catch (NumberFormatException e) {
			throw new CsvLineException();
		} catch (IllegalArgumentException e) {
			throw new CsvLineException();
		}

	}

	private static List<Purchase> getPurchases(Scanner input)
			throws WrongCsvException {
		List<Purchase> purchases = new ArrayList<Purchase>();
		try {
			while (input.hasNext()) {
				Purchase purchase = getPurchase(input);
				purchases.add(purchase);
			}
			return purchases;
		} catch (CsvLineException e) {
			throw new WrongCsvException(e);
		}
	}
}
