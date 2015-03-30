package by.gsu.epamlab;

import java.util.Scanner;

public class PurchaseFactory {

	public static enum PurchseType{
		GENERAL_PURCHASE{
			@Override
			Purchase getPurchase(Scanner sc) {
				return new Purchase(sc);
			}},
		PRICE_DISCOUNT{
			@Override
			Purchase getPurchase(Scanner sc) {
				return new PriceDiscountPurchase(sc);
			}},
		RELATIVE_DISCOUNT{
			@Override
			Purchase getPurchase(Scanner sc) {
				return new RelativeDiscountPurchase(sc);
			}};
		
		abstract Purchase getPurchase(Scanner sc);
	}
	
	public static Purchase getPurchaseFromFactory(Scanner sc){
		String id = sc.next();		
		return PurchseType.valueOf(id.toUpperCase()).getPurchase(sc);	
	}
}
