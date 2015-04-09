package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {

	private int discount = 100;

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public PriceDiscountPurchase() {
		super();
	}

	public PriceDiscountPurchase(Scanner sc) {
		super(sc);
		this.discount = sc.nextInt();
	}

	public PriceDiscountPurchase(String name, int price, int number,
			int discount) {
		super(name, price, number);
	}
	
	public PriceDiscountPurchase(String[] line){
		super(line);
		
	}

	@Override
	public double getCost() {
		return (getPrice() - this.discount) * getNumber();
	}

	@Override
	public String toString() {
		return fieldsToString() + "; " + getCost();
	}

	protected String fieldsToString() {
		return super.fieldsToString() + "; " + discount;
	}

}
