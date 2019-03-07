import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;



public class CustomerDaoImpl implements CustomerDao{
	
	ArrayList <Customer> customers=new ArrayList <Customer> ();

		
		public CustomerDaoImpl(ArrayList<Customer> customers) {
		
		this.customers = customers;
	}
		
		

		public void add(Customer customer) {
			customers.add(customer);
			
		}

		public void update(int id, Customer customer) {
			System.out.println();
			
		}

		public void delete(int id) {
			int j=-1;
			for(int i=0;i<customers.size();i++){
				if(customers.get(i).id == id){
					j=i;
					break;
				}
			}
			if(j!=-1)
			customers.remove(j);
			
		}

		public  Customer[] getAll() {
			
			Customer [] g =new Customer[200];
			Customer a;
	
			for(int i=0;i<customers.size();i++){
				a=customers.get(i);
				g[i]=a;
				//bw3.write(a.getId()+" "+a.getName()+" "+a.getSurname()+" "+a.getPhoneNumber()+" "+a.getAdress());
			}
			return g;
		}
		
		
		public  int findCustomerIndex(int id){
			int j=-1;
			for(int i=0;i<customers.size();i++){
				if(customers.get(i).id == id){
					j=i;
					break;
				}
			}
			return j;
		}
		
		
		
		
		
	
	
	
}
