package by.gsu.epamlab;
import java.util.Scanner;

public class Purchase {

	private String name;
	private double price;
	private int number;
	
	public Purchase() {
		
	}
	public Purchase(String name, double price, int number) {
		super();
		this.name = name;
		this.price = price;
		this.number = number;
	}
	
	public Purchase(Scanner input){
			this.name = input.next();
			System.out.println(this.name);
			this.price = input.nextDouble();
			System.out.println(this.price);
			this.number = input.nextInt();
			System.out.println(this.number);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public double getCost(){
		return this.price * this.number;
	}
	@Override
	public String toString() {
		return this.name + ";" + this.price + ";" + this.number + ";" + this.getCost() + "\n";
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
		if (getClass() != obj.getClass())
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
