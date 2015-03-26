package by.gsu.epamlab;

import java.util.Scanner;

public class PurchaseFactory {

	public static enum PurchseType{
		GENERAL_PURCHASE, PRICE_DISCOUNT, RELATIVE_DISCOUNT
	}
	
	public static Purchase getPurchaseFromFactory(Scanner sc){
		String id = sc.next();
		PurchseType type = PurchseType.valueOf(id);
		switch(type){	
		case GENERAL_PURCHASE:
			return new Purchase(sc);
		case PRICE_DISCOUNT:
			return new PriceDiscountPurchase(sc);
		case RELATIVE_DISCOUNT:
			return new RelativeDiscountPurchase(sc);
		default:
			throw new IllegalArgumentException();
		}
		
	}
	
}
