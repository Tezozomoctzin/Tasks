package by.gsu.epamlab;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
	
	Commodity commodity;
	private int number;
	
	public AbstractPurchase() {
		super();
	}

	public AbstractPurchase(Commodity commodity, int number) {
		super();
		this.commodity = commodity;
		this.number = number;
	}
	
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	abstract double getCost();

	@Override
	public int compareTo(AbstractPurchase o) {
		return (this.getCost() < o.getCost() ? 1 : (this.getCost() > o.getCost() ? -1 : 0));
	}

	@Override
	public String toString() {
		return this.commodity.toString() + "; " + this.number + "; " + this.getCost();
	}
	
	
}
