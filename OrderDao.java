
public interface OrderDao {

	public void createOrder(Order order);
	public void addPizza(int orderId,Pizza newPizza);
	public void addDrink();
	public double PayCheck();
	
}
