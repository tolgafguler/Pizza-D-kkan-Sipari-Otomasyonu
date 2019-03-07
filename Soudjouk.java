
public class Soudjouk extends PizzaDecorator {
protected Pizza pizza;
	
	public Soudjouk(Pizza pizza){
		super(pizza);
		this.pizza=pizza;
	}
	
	public double cost() {
		return this.pizza.cost()+3;
	}

	public String name() {
		
		return this.pizza.name()+" "+"Soudjuk";
	}



}
