import java.util.Arrays;

import by.gsu.epamlab.AbstractPurchase;
import by.gsu.epamlab.Commodity;
import by.gsu.epamlab.PurchaseFactory;


public class Runner {

	public static void main(String[] args) {
		
		final Commodity HOSE = new Commodity("Hose", 7000);
		AbstractPurchase[] purchases = new AbstractPurchase[6];
		purchases[0] = PurchaseFactory.getPurchaseFromFactory("regular", HOSE, 5);
		purchases[1] = PurchaseFactory.getPurchaseFromFactory("regular", HOSE, 4);
		purchases[2] = PurchaseFactory.getPurchaseFromFactory("relative", HOSE, 10);
		purchases[3] = PurchaseFactory.getPurchaseFromFactory("relative", HOSE, 6);
		purchases[4] = PurchaseFactory.getPurchaseFromFactory("additional", HOSE, 3);
		purchases[5] = PurchaseFactory.getPurchaseFromFactory("additional", HOSE, 1);
		showArray(purchases);
		Arrays.sort(purchases);
		System.out.println("");
		showArray(purchases);
		System.out.println();
		
	}
	
	private static void showArray(AbstractPurchase[] array){
		for(AbstractPurchase abstractPurchase: array){
			System.out.println(abstractPurchase);
		}
	}

}
