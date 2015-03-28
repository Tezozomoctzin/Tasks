package by.gsu.epamlab;

public class RelativeDiscountPurchase extends AbstractPurchase{
	
	private final int THRESHOLD = 3;
	private final double PERCENTAGE = 12.5;
	
	public RelativeDiscountPurchase() {
		super();
	}

	public RelativeDiscountPurchase(Commodity commodity, int number) {
		super(commodity, number);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	double getCost() {
		return (super.getNumber() > this.THRESHOLD) ? (super.commodity.getPrice() * super.getNumber() * (1 - this.PERCENTAGE/100)) : (super.commodity.getPrice() * super.getNumber());
	}
	
}
