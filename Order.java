import java.util.ArrayList;


public class Order {
	protected int orderId;
	protected int customerId;
	protected int drink;
	ArrayList<Pizza> basket;
	
	public int getOrderId() {
	return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Order(int orderId, int customerId) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.basket=new ArrayList<Pizza>();
		
	}
	public int getDrink() {
		return drink;
	}
	public void setDrink(int drink) {
		this.drink = drink;
	}
	
	

}
