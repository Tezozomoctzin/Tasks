package by.gsu.epamlab;

import java.util.Scanner;

public class PurchaseFactory {

	public static enum PurchseType{
		GENERAL_PURCHASE {
			@Override
			Purchase getPurchase(String[] line) {
				return new Purchase(line);
			}
		},
		PRICE_DISCOUNT {
			@Override
			Purchase getPurchase(String[] line) {
				return new PriceDiscountPurchase(line);
			}
		};

		abstract Purchase getPurchase(String[] line);
	}

	public static Purchase getPurchaseFromFactory(String[] line) {
		return PurchseType.valueOf(line[Constants.PURCHASE_TYPE].toUpperCase()).getPurchase(line);
	}
}
