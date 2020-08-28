package bankify;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 4584;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
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
		String withdrawAmount = request.getParameter("amountWithdraw");
		String accountType=(String) request.getParameter("accountType");
		String accountNumber=(String) request.getParameter("accountNumber");
		int anum= Integer.parseInt(accountNumber);
		boolean accountexists=false;
	
		int withdrawAmn= Integer.parseInt(withdrawAmount);
		int amount = 0;
		Statement stmt;
		HttpSession session=request.getSession();
		String usr_name=(String) session.getAttribute("usr_name");
		int newBalance;
		String accountTyp=null;
		int accountNum=0;
		String message;
		try {
			stmt = DatabaseConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from NEWACCOUNT where USERNAME = '" + usr_name
					+ "'and ACC_TYP = '" + accountType + "' and ACCOUNTNO = '" + accountNumber + "'");
			while (rs.next()) {
				amount = rs.getInt(6);
				accountTyp = rs.getString(9);
				accountNum = rs.getInt(1);

			}
			if (anum == accountNum && accountType.toUpperCase().equals(accountTyp)) {
				accountexists = true;
			}
			if (accountexists && amount - withdrawAmn > 0) {
				newBalance = amount - withdrawAmn;
				String queryToUpdateAmount = "Update NEWACCOUNT set AMOUNT = " + newBalance + " where USERNAME = '"
						+ usr_name + "'and ACC_TYP = '" + accountType + "' and ACCOUNTNO = '" + accountNumber + "'";
				PreparedStatement preparedStmtqueryToUpdateAmount = DatabaseConnection.getConnection()
						.prepareStatement(queryToUpdateAmount);
				preparedStmtqueryToUpdateAmount.executeUpdate();
				System.out.println("balance updated successfully");
				List<Customer> custom = new ArrayList<Customer>();
				Customer customer = new Customer();
				custom = customer.getCustomerDetails(usr_name);
				request.setAttribute("balance", custom);
				request.setAttribute("username", usr_name);
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);

			}
			if (accountexists && amount - withdrawAmn < 0) {
				message = "Not Sufficient Balance to Withdraw";
			} else {
				message = "Account does not exists";
			}
			request.setAttribute("message", message);
			request.getRequestDispatcher("WithdrawAmount.jsp").forward(request, response);

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
