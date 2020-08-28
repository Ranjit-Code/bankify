package bankify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Default extends HttpServlet {
	private static final long serialVersionUID = 33;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Default() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username=(String) session.getAttribute("usr_name");
		
		 List<Customer> custom = new ArrayList<Customer>();
         Customer customer=new Customer();
         custom= customer.getCustomerDetails(username);
         request.setAttribute("balance", custom);
         request.setAttribute("username", username);
         request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

}
