package by.gsu.epamlab;

import java.util.Scanner;

public class RelativeDiscountPurchase extends Purchase {

	private final int THRESHOLD = 25;
	private final double DISCOUNT = 7.75;

	public RelativeDiscountPurchase() {
		super();
	}

	public RelativeDiscountPurchase(Scanner sc) {
		super(sc);
	}

	public RelativeDiscountPurchase(String name, double price, int number) {
		super(name, price, number);
	}

	protected String fieldsToString(){
		return super.getName() + "; " + super.getPrice() + "; " + super.getNumber() + "; ";
	}

	@Override
	public double getCost() {
		return (super.getNumber() > this.THRESHOLD) ? Math.round((super.getCost() * (1 - this.DISCOUNT/100))) : super.getCost(); 
	}

	@Override
	public String toString() {
		return fieldsToString() + this.getCost();
	}
	
	
	
}
