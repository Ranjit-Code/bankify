package bankify;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 187849494;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountType = request.getParameter("accountType");
		accountType=accountType.toUpperCase();
		HttpSession session = request.getSession();
		String username=(String) session.getAttribute("usr_name");
		boolean accountExist=false;
		String fullname=null;
		String password=null;
		String address=null;
		String phone=null;
		
		try {
		Statement stmt = DatabaseConnection.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery("select * from NEWACCOUNT where USERNAME = '" + username + "'");
		while(rs.next()) {
			fullname = rs.getString(3);	
			password=rs.getString(4);	
			address=rs.getString(7);
			phone=rs.getString(8);
			if(rs.getString(9).equals(accountType)) {
				accountExist=true;
			}
		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!accountExist) {
		try {
 				PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement( 
 						"insert into NEWACCOUNT(FULLNAME, USERNAME, PASSWORD, ADDRESS,PHONE,ACCOUNTNO,ACC_TYP) values (?,?,?,?,?,?,?)");
 				ps.setString(1,fullname);  
 				ps.setString(2,username);  
 				ps.setString(3,password);  
 				ps.setString(4,address);  
 				ps.setString(5,phone);  
 				ps.setString(6,((Integer)randomGenerator()).toString());  
 				ps.setString(7,accountType.toUpperCase());  
 				
 				int i=ps.executeUpdate();  
 				if(i>0)  
 				System.out.println("Account created successfully .."+accountType);
                List<Customer> custom = new ArrayList<Customer>();
                Customer customer=new Customer();
                custom= customer.getCustomerDetails(username);
                request.setAttribute("balance", custom);
                request.setAttribute("username", username);
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
 				//DatabaseConnection.getConnection().close();				
 				//response.sendRedirect("dashboard.jsp");
 				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}	else {
			request.setAttribute("message", "Account Already exists");
			request.getRequestDispatcher("createAccount.jsp").forward(request, response);
		}
		/*
		 * if(username.isEmpty() || password.isEmpty() ) { RequestDispatcher req =
		 * request.getRequestDispatcher("Login.jsp"); req.include(request, response); }
		 * else { RequestDispatcher req = request.getRequestDispatcher("HomePage.jsp");
		 * req.forward(request, response); }
		 */
	
	}
	 public static int randomGenerator () {
    	 Random rnd = new Random();
    	 int n = 100000 + rnd.nextInt(900000);
		return n;
     }
}
