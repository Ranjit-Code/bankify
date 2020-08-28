package bankify;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 

public class Login extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Statement stmt;
		Customer cust =new Customer();
		try {
			stmt = DatabaseConnection.getConnection().createStatement();
			/* retrieving the record on the basis of college id */
			ResultSet rs = stmt.executeQuery("select * from NEWACCOUNT where USERNAME = '" + username + "'");
			String usr_name=null;
			String pass=null;
			if (rs.next()) {
				usr_name = rs.getString(2);
				pass = rs.getNString(4);
				if (username.equalsIgnoreCase(usr_name) && password.equalsIgnoreCase(pass)) {
					System.out.println("Login Successful");
				      HttpSession session = request.getSession(true);
                      session.setAttribute("usr_name", usr_name);
                    List<Customer> custom = new ArrayList<Customer>();
                      Customer customer=new Customer();
                      custom= customer.getCustomerDetails(usr_name);
                      request.setAttribute("balance", custom);
                      request.setAttribute("username", usr_name);
                      request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				}
			}
			
			else {

				String message = "Please check your credentials";
				request.setAttribute("message", message);
			//	response.sendRedirect("Login.jsp");
				request.getRequestDispatcher("Login.jsp").forward(request, response);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		/*
		 * if(username.isEmpty() || password.isEmpty() ) { RequestDispatcher req =
		 * request.getRequestDispatcher("Login.jsp"); req.include(request, response); }
		 * else { RequestDispatcher req = request.getRequestDispatcher("HomePage.jsp");
		 * req.forward(request, response); }
		 */
	}
 
}