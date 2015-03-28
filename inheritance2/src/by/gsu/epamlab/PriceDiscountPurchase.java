package by.gsu.epamlab;

public class PriceDiscountPurchase extends AbstractPurchase{

	private final double DISCOUNT = 200;
	
	public PriceDiscountPurchase() {
		super();
	}

	public PriceDiscountPurchase(Commodity commodity, int number) {
		super(commodity, number);
	}

	@Override
	double getCost() {
		return (super.commodity.getPrice() - this.DISCOUNT) * super.getNumber();
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
