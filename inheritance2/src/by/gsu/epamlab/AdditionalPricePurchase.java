package by.gsu.epamlab;

public class AdditionalPricePurchase extends AbstractPurchase{

	private final double EXPENCES = 350;
	
	public AdditionalPricePurchase() {
		super();
	}

	public AdditionalPricePurchase(Commodity commodity, int number) {
		super(commodity, number);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	double getCost() {
		return (super.commodity.getPrice() + this.EXPENCES) * super.getNumber();
	}

	
	
}
