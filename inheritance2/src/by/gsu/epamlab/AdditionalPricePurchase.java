package by.gsu.epamlab;

public class AdditionalPricePurchase extends AbstractPurchase{

	private double expences = 350;
	
	public AdditionalPricePurchase() {
		super();
	}

	public AdditionalPricePurchase(Commodity commodity, int number, double expences) {
		super(commodity, number);
		this.expences = expences;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public double getCost() {
		return (super.commodity.getPrice() + this.expences) * super.getNumber();
	}

	
	
}
