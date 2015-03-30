package by.gsu.epamlab;

import java.util.Scanner;

public class RelativeDiscountPurchase extends Purchase {

	private int threshold = 3;
	private double discount ;

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public RelativeDiscountPurchase() {
		super();
	}

	public RelativeDiscountPurchase(Scanner sc) {
		super(sc);
		this.discount = sc.nextDouble();
	}

	public RelativeDiscountPurchase(String name, int price, int number, double discount) {
		super(name, price, number);
		this.discount = discount;
	}
	
	protected String fieldsToString() {
		return  super.fieldsToString() + "; " + discount;
	}

	
	@Override
	public double getCost() {
		return (super.getNumber() > this.threshold) ? Math.round((super.getCost() * (1 - this.discount/100))) : super.getCost(); 
	}

	@Override
	public String toString() {
		return fieldsToString() + "; " + getCost();
	}
	
	
	
}
