package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {

	private final double DISCOUNT = 100;
	
	public PriceDiscountPurchase() {
		super();
	}

	public PriceDiscountPurchase(Scanner sc) {
		super(sc);
	}

	public PriceDiscountPurchase(String name, double price, int number) {
		super(name, price, number);
	}

	@Override
	public double getCost() {
		return (super.getPrice() - this.DISCOUNT) * super.getNumber(); 
	}

	protected String fieldsToString(){
		return super.getName() + ";" + super.getPrice() + ";" + super.getNumber() + ";";
	}
	
	@Override
	public String toString() {
		return fieldsToString() + this.getCost();
	}
	
	
	
}
