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
			for(int i = 0; i < purchases.length; i++){
				purchases[i] = PurchaseFactory.getPurchaseFromFactory(scan);
				purchases[i].toString();
				if(allEqual = true){
					allEqual = purchases[i].equals(purchases[0]);
					System.out.println("pop");
				}
				if(maxCostPurchase.getCost() > purchases[i].getCost())
				{
					maxCostPurchase = purchases[i];
				}				
			}
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			e.printStackTrace();
		}
		System.out.println("T_T");
	}

}
