
public class Product implements ShippingService {

	private String name;
	private double price;
	private int quantity;
	private boolean isExpireable;
	private boolean isExpired;
	private boolean isShippable;
	private double weight;
	
	public Product() {
	}

	public Product(String name, double price, int quantity, boolean isExpireable, boolean isExpired,
			boolean isShippable, double weight) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.isExpireable = isExpireable;
		this.isExpired = isExpired;
		this.isShippable = isShippable;
		this.weight = weight;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isExpireable() {
		return isExpireable;
	}

	public void setExpireable(boolean isExpireable) {
		this.isExpireable = isExpireable;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	public boolean isShippable() {
		return isShippable;
	}

	public void setShippable(boolean isShippable) {
		this.isShippable = isShippable;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	
	
	
	
	
}
