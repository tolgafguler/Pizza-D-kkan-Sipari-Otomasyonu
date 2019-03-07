
public class HotPepper extends PizzaDecorator {
protected Pizza pizza;
	
	public HotPepper(Pizza pizza){
		super(pizza);
		this.pizza=pizza;
	}
	
	public double cost() {
		return this.pizza.cost()+1;
	}

	public String name() {
		
		return this.pizza.name()+"Hot Pepper";
	}




}
