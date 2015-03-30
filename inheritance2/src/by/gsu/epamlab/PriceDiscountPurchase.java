package by.gsu.epamlab;

public class PriceDiscountPurchase extends AbstractPurchase{

	private int discount = 200;
	
	public PriceDiscountPurchase() {
		super();
	}

	public PriceDiscountPurchase(Commodity commodity, int number, int discount) {
		super(commodity, number);
		this.discount = discount;
	}

	@Override
	public double getCost() {
		return (super.commodity.getPrice() - this.discount) * super.getNumber();
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
