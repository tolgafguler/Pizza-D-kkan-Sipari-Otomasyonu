
public abstract class PizzaDecorator implements Pizza	 {
	
	protected Pizza pizza;
	
	public PizzaDecorator(Pizza pizza){
		this.pizza=pizza;
		
	}

	public double cost() {
		return this.pizza.cost();
	}

	public String name() {
		
		return this.pizza.name();
	}


}
