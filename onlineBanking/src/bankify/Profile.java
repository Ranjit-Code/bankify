package bankify;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1878494;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
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
		HttpSession session = request.getSession();
		String username=(String) session.getAttribute("usr_name");
		try {
			Statement stmt;
			  Customer cus=new Customer();
			  int TotalBalance=0;
			stmt = DatabaseConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from NEWACCOUNT where USERNAME = '" + username + "'");
			while (rs.next()) {		  
		   cus.setFull_name(rs.getString(3));
		   cus.setAddress(rs.getString(7));
		   cus.setPhone(rs.getInt(8));
		   cus.setAccountType(rs.getString(9));
		   cus.setAccountno( rs.getInt(1));
		   cus.setAmount(rs.getInt(6));		  
		    TotalBalance=TotalBalance+rs.getInt(6);
			}
			cus.getFull_name();
			
            request.setAttribute("fullname", cus.getFull_name());
            request.setAttribute("address", cus.getAddress());
            request.setAttribute("phone", cus.getPhone());
            request.setAttribute("totalbal", TotalBalance);

            request.getRequestDispatcher("Profile.jsp").forward(request, response);
			
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 				
			} 

	
		/*
		 * if(username.isEmpty() || password.isEmpty() ) { RequestDispatcher req =
		 * request.getRequestDispatcher("Login.jsp"); req.include(request, response); }
		 * else { RequestDispatcher req = request.getRequestDispatcher("HomePage.jsp");
		 * req.forward(request, response); }
		 */
	
	
}
