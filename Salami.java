
public class Salami extends PizzaDecorator {
	
	protected Pizza pizza;
	
	public Salami(Pizza pizza){
		super(pizza);
		this.pizza=pizza;
	}
	
	public double cost() {
		return this.pizza.cost()+3;
	}

	public String name() {
		
		return this.pizza.name()+" "+"Salami";
	}



}
