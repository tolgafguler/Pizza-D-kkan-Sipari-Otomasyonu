
public class Onion extends PizzaDecorator{
protected Pizza pizza;
	
	public Onion(Pizza pizza){
		super(pizza);
		this.pizza=pizza;
	}
	
	public double cost() {
		return this.pizza.cost()+2;
	}

	public String name() {
		
		return this.pizza.name()+" "+"Onion";
	}



}
