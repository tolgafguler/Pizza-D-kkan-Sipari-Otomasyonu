import java.util.List;


public interface CustomerDao {
	public void add(Customer customer);  
	 
	public void update(int id, Customer customer); 
	 
	public void delete(int id);  
	 
	public Customer[] getAll(); 
	public int findCustomerIndex(int id);
	 
}
