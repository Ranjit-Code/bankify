package bankify;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	 String full_name = request.getParameter("full_name");
 		String username = request.getParameter("username");
 		String password = request.getParameter("password");
 		String address = request.getParameter("address");
 		String phone = request.getParameter("phone");
 		
 		if(full_name.isEmpty() || username.isEmpty() || 
 				password.isEmpty() || address.isEmpty() || phone.isEmpty())
 		{
 			RequestDispatcher req = request.getRequestDispatcher("Reg.jsp");
 			req.include(request, response);
 		}
 		else
 		{
 			try {
 				PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement( 
 						"insert into NEWACCOUNT(FULLNAME, USERNAME, PASSWORD, ADDRESS,PHONE,ACCOUNTNO,ACC_TYP) values (?,?,?,?,?,?,?)");
 				ps.setString(1,full_name);  
 				ps.setString(2,username);  
 				ps.setString(3,password);  
 				ps.setString(4,address);  
 				ps.setString(5,phone);  
 				ps.setString(6,((Integer)randomGenerator()).toString());  
 				ps.setString(7,"SAVINGS");  
 				
 				int i=ps.executeUpdate();  
 				if(i>0)  
 				System.out.println("You are successfully registered...");
 				DatabaseConnection.getConnection().close();				
 				response.sendRedirect("Login.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
			 * req.forward(request, response);
			 */
 		}
 	}
     
     public static int randomGenerator () {
    	 Random rnd = new Random();
    	 int n = 100000 + rnd.nextInt(900000);
		return n;
     }
 
}
