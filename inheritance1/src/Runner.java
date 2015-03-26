import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchaseFactory;


public class Runner {

	public static void main(String[] args) {
		boolean allEqual;
		File file = new File("in.txt");
		Purchase maxCostPurchase = new Purchase();
		Purchase[] purchases = new Purchase[6]; 
		Scanner scan;
		try {
			scan = new Scanner(file);
			scan.useLocale(Locale.ENGLISH);
			for(Purchase purchase : purchases){
				purchase = PurchaseFactory.getPurchaseFromFactory(scan);
				purchase.toString();
				if(allEqual = true){
					allEqual = purchase.equals(purchases[0]);
				}
				if(maxCostPurchase.getCost() > purchase.getCost())
				{
					maxCostPurchase = purchase;
				}				
			}
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			e.printStackTrace();
		}
		System.out.println("T_T");
	}

}
