package fruitstore.demain;

public class FruitItem {
	private String number;
	private String name;
	private double price;
	private String unit;
	
	public FruitItem() {
		
	}
	public FruitItem(String number, String name, double price, String unit) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.unit = unit; 
	}
	
	public String getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String getUnit() {
		return unit;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
