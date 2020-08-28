package bankify;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Customer implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 44545501 ;
    
    private String full_name;
    private String username;
    private String address;
    private int phone;
    private String accountType;
    private int accountno;
    public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}

	private int amount;
    
    public Customer getInstance()
    {
		return this;
    	
    }
    public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/*
	 * public HashMap<String, Integer> getBalanceDetails(String user_name) {
	 * HashMap<String, Integer> balances = new HashMap<String, Integer>(); try {
	 * Statement stmt; stmt = DatabaseConnection.getConnection().createStatement();
	 * ResultSet rs =
	 * stmt.executeQuery("select * from NEWACCOUNT where USERNAME = '" + user_name +
	 * "'"); while (rs.next()) {
	 * 
	 * balances.put(rs.getString(1), rs.getInt(6)); }
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return balances; }
	 */
	
	public List<Customer> getCustomerDetails(String user_name) {
		List<Customer> customer = new ArrayList <Customer> ();
			try {
			Statement stmt;
			stmt = DatabaseConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from NEWACCOUNT where USERNAME = '" + user_name + "'");
			while (rs.next()) {
		   Customer cus=new Customer();
		  
		   cus.setFull_name(rs.getString(3));
		   cus.setAddress(rs.getString(7));
		   cus.setPhone(rs.getInt(8));
		   cus.setAccountType(rs.getString(9));
		   cus.setAccountno( rs.getInt(1));
		   cus.setAmount(rs.getInt(6));
		  
		   customer.add(cus);

			}
			
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
		}
}
