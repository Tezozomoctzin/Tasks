package by.gsu.epamlab;

import java.util.Scanner;

public class Purchase {

	private String name;
	private int price;
	private int number;

	public Purchase() {

	}

	public Purchase(String name, int price, int number) {
		super();
		this.name = name;
		this.price = price;
		this.number = number;
	}

	public Purchase(Scanner input) {
		this.name = input.next();
		this.price = input.nextInt();
		this.number = input.nextInt();
	}

	public Purchase(String[] line) {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException(Constants.NULL_STRING);
		}
		if ("".equals(name)) {
			throw new IllegalArgumentException(Constants.EMPTY_STRING);
		}
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(String price) {
		int parsedPrice = 0;
		try {
			parsedPrice = Integer.parseInt(price);
			if (parsedPrice >= 0) {
				this.price = parsedPrice;
			} else {
				System.err.println("Wrong number value");
			}
		} catch (NumberFormatException e) {
			System.err.println("Wrong number format");
		}

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getCost() {
		return this.price * this.number;
	}

	@Override
	public String toString() {
		return this.name + "; " + this.price + "; " + this.number + "; "
				+ this.getCost();

	}

	protected String fieldsToString() {
		return name + "; " + price + "; " + number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Purchase))
			return false;
		Purchase other = (Purchase) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}
}
