package by.gsu.epamlab;

public class RelativeDiscountPurchase extends AbstractPurchase{
	
	private int threshold = 3;
	private double percent = 12.5;
	
	public RelativeDiscountPurchase() {
		super();
	}

	public RelativeDiscountPurchase(Commodity commodity, int number, double percent) {
		super(commodity, number);
		this.percent = percent;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public double getCost() {
		return Math.round((super.getNumber() > this.threshold) ? (super.commodity.getPrice() * super.getNumber() * (1 - this.percent/100)) : (super.commodity.getPrice() * super.getNumber()));
	}
	
}
