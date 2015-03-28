package by.gsu.epamlab;

public class PurchaseFactory {
	
	public static enum PurchaseType{
		REGULAR, RELATIVE, ADDITIONAL
	}

	public static AbstractPurchase getPurchaseFromFactory(String type, Commodity commodity, int number){
		PurchaseType name = PurchaseType.valueOf(type.toUpperCase());
		switch(name){
		case REGULAR:
			return new PriceDiscountPurchase(commodity, number);
		case RELATIVE:
			return new RelativeDiscountPurchase(commodity, number);
		case ADDITIONAL:
			return new AdditionalPricePurchase(commodity, number);
		default:
			throw new IllegalArgumentException("Wrong type");
		}
	}
	
}
