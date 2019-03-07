import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

public class Main {
	public static void main (String []args){
		
		ArrayList<Customer> customers=new ArrayList<Customer>();
		ArrayList<Order> orders=new ArrayList<Order>();
		
		int drinkCounter=0;
		String arg=args[0];
		String s[]={};
		try{
		File fileOutput=new File("customer.txt");
        FileWriter fw1 = new FileWriter(fileOutput, false);
        BufferedWriter bw1 = new BufferedWriter(fw1);
        
        File fileOutput1=new File("order.txt");
        FileWriter fw2 = new FileWriter(fileOutput1, false);
        BufferedWriter bw2 = new BufferedWriter(fw2);
			
        File fileOutput2=new File("output.txt");
        FileWriter fw3 = new FileWriter(fileOutput2, false);
        BufferedWriter bw3 = new BufferedWriter(fw3);
			
        
			File file = new File(arg);
			FileReader fr = new FileReader(file);
			BufferedReader bf=new BufferedReader(fr);
			
			String line = bf.readLine();
			
			while (line != null) {
				
				s=line.split(" ");
				
			
				if(s[0].equals("AddCustomer")){
					String address="";
					for(int i=5;i<s.length;i++){
						address+=s[i]+" ";}
					Customer c=new Customer(Integer.parseInt(s[1]),s[2],s[3],s[4],address);
					CustomerDaoImpl k=new CustomerDaoImpl(customers);
					k.add(c);
					bw3.write("Customer"+" "+c.getId()+" "+c.getName()+" "+"added");
					bw3.newLine();
					
				}
				else if(s[0].equals("RemoveCustomer")){
					CustomerDaoImpl o=new CustomerDaoImpl(customers);
					int u=Integer.parseInt(s[1]);
					o.delete(u);
					bw3.write("Customer"+" "+u+" "+"removed");
					bw3.newLine();
				}
				else if(s[0].equals("List")){
					CustomerDaoImpl l=new CustomerDaoImpl(customers);
					Customer h []=new Customer[200];
					bw3.write("Customer List:");
					bw3.newLine();
					h=l.getAll();
					for (int y=0;y<customers.size();y++){
						bw3.write(h[y].getId()+" "+h[y].getName()+" "+h[y].getSurname()+" "+h[y].getPhoneNumber()+" "+h[y].getAdress());
						bw3.newLine();
						bw1.write(h[y].getId()+" "+h[y].getName()+" "+h[y].getSurname()+" "+h[y].getPhoneNumber()+" "+h[y].getAdress());
						bw1.newLine();
					}
				}
				
				else if(s[0].equals("CreateOrder")){
					Order orderObject=new Order(Integer.parseInt(s[1]),Integer.parseInt(s[2]));
					OrderDaoImpl p=new OrderDaoImpl(orders);
					p.createOrder(orderObject);
					bw3.write("Order"+" "+Integer.parseInt(s[1])+" "+"is created");
					bw3.newLine();
					bw2.write("Order:"+" "+Integer.parseInt(s[1]));
					bw2.newLine();
					
				}
				else if(s[0].equals("AddPizza")){
					if (s.length==7){
						bw3.write("You can not add 4 toppings");
						bw3.newLine();
					}
					else{
					OrderDaoImpl a=new OrderDaoImpl(orders);
					int orderId=a.findOrder(Integer.parseInt(s[1]));
					Pizza piz = null;
					if(s[2].equals("AmericanPan")){
						piz=new Americano();
						bw3.write("AmericanPan pizza added to order"+" "+Integer.parseInt(s[1]));
						bw3.newLine();
						
					}
					else if(s[2].equals("Napolitan")){
						piz=new Napoliten();
						bw3.write("Napolitan pizza added to order"+" "+Integer.parseInt(s[1]));
						bw3.newLine();
					}
					
					
					for(int i=3;i<s.length;i++){
						
						if(s[i].equals("salami")){
							piz=new Salami(piz);
						}
						else if(s[i].equals("onion")){
							piz=new Onion(piz);	
						}
						else if(s[i].equals("soudjouk")){
							piz=new Soudjouk(piz);
						}
						else if (s[i].equals("pepper")){
							piz=new HotPepper(piz);
						}
					}
					
						
					orders.get(orderId).basket.add(piz);
						
					
					
					}
				}
				else if(s[0].equals("AddDrink")){
					drinkCounter++;
					OrderDaoImpl a=new OrderDaoImpl(orders);
					int orderId=a.findOrder(Integer.parseInt(s[1]));
					for(int j=0;j<orders.size();j++){
						if(orders.get(j).orderId==orderId){
							
							orders.get(j).setDrink(1);
							
							
						}
					}
				}
				else if(s[0].equals("PayCheck")){
					OrderDaoImpl a=new OrderDaoImpl(orders);
					int orderId=a.findOrder(Integer.parseInt(s[1]));
					int total=0;
					bw3.write("PayCheck for order "+s[1]);
					bw3.newLine();
					for(int k=0;k<orders.get(orderId).basket.size();k++){
						total+=orders.get(orderId).basket.get(k).cost();
						bw3.write("\t"+orders.get(orderId).basket.get(k).name()+" "+orders.get(orderId).basket.get(k).cost()+" $");
						bw3.newLine();
						bw2.write(orders.get(orderId).basket.get(k).name());
						bw2.newLine();
					}
					if(orders.get(orderId).drink>=0){
						for (int i=0;i<drinkCounter;i++){
						total+=1;
						bw3.write("Soft Drink 1 $");
						bw3.newLine();
						bw2.write("Soft Drink 1 $");
						bw2.newLine();}
						drinkCounter=0;
					}
					bw3.write("Total "+total+" $");
					bw3.newLine();
				}
				
				line= bf.readLine();
			}
			bf.close();
			bw3.close();
			bw2.close();
			bw1.close();
		}
	catch(IOException iox){
		System.out.println("cant read");
	}
		
		
		
	}
	
	
}
