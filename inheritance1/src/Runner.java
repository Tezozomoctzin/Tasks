import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchaseFactory;


public class Runner {	
	public static void main(String[] args) {
		boolean allEqual = true;
		File file = new File("src/in.txt");
		Purchase maxCostPurchase = new Purchase("goods", 0, 0);
		Purchase[] purchases = new Purchase[6];
		Scanner scan = null;
		try {
			scan = new Scanner(file);
			scan.useLocale(Locale.ENGLISH);
			for(int i = 0; i < purchases.length; i++){
				purchases[i] = PurchaseFactory.getPurchaseFromFactory(scan);
				System.out.println(purchases[i].toString()); 
				if(allEqual == true){
					allEqual = purchases[i].equals(purchases[0]);
				}
				if(maxCostPurchase.getCost() < purchases[i].getCost())
				{
					maxCostPurchase = purchases[i];
				}				
			}
			System.out.println((allEqual == true) ? ("All purchases are equal") : "Purchases are not equal");
			System.out.println("Purchase with maximum cost is: " + maxCostPurchase.toString());
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			e.printStackTrace();
		}finally{
			if(scan != null){		
				scan.close();
			}
		}
	}

}
