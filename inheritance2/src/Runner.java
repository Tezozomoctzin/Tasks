import java.util.Arrays;

import by.gsu.epamlab.AbstractPurchase;
import by.gsu.epamlab.AdditionalPricePurchase;
import by.gsu.epamlab.Commodity;
import by.gsu.epamlab.PriceDiscountPurchase;
import by.gsu.epamlab.RelativeDiscountPurchase;


public class Runner {

	public static void main(String[] args) {
		
		final Commodity HOSE = new Commodity("Hose", 7000);
		AbstractPurchase[] purchases = new AbstractPurchase[6];
		purchases[0] = new PriceDiscountPurchase(HOSE, 5, 150);
		purchases[1] = new PriceDiscountPurchase(HOSE, 4, 250);
		purchases[2] = new RelativeDiscountPurchase(HOSE, 10, 7);
		purchases[3] = new RelativeDiscountPurchase(HOSE, 6, 5.5);
		purchases[4] = new AdditionalPricePurchase(HOSE, 3, 300);
		purchases[5] = new AdditionalPricePurchase(HOSE, 1, 190);
		showArray(purchases);
		System.out.println("");
		Arrays.sort(purchases);
		showArray(purchases);
		System.out.println("\nMinimum purchase cost = " + purchases[purchases.length - 1].getCost());
	}
	
	private static void showArray(AbstractPurchase[] array){
		for(AbstractPurchase abstractPurchase: array){
			System.out.println(abstractPurchase);
		}
	}

}
