import java.util.ArrayList;


public class OrderDaoImpl implements OrderDao {

	ArrayList<Order> orders=new ArrayList<Order>();
	
	
	public OrderDaoImpl(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public void createOrder(Order order) {
		orders.add(order);
		
	}

	public void addPizza(int orderId, Pizza newPizza) {
		// TODO Auto-generated method stub
		
	}

	public void addDrink() {
		// TODO Auto-generated method stub
		
	}

	public double PayCheck() {
		
		return 0;
	}
	
	public int findOrder(int id){
		int j=-1;
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).orderId==id){
				j=i;
			}
		}
		return j;

	}

}
