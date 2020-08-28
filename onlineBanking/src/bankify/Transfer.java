package bankify;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 4584;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
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
		String amountTransfer = request.getParameter("amountTransfer");	
		String sendaccountType=(String) request.getParameter("accountType");
		String toAccountNumber=(String) request.getParameter("toAccountNumber");
		String recaccountType=(String) request.getParameter("recaccountType");
		String message;
			int anum= Integer.parseInt(toAccountNumber);
		    int withdrawAmn= Integer.parseInt(amountTransfer);
			HttpSession session=request.getSession();
			String usr_name=(String) session.getAttribute("usr_name");
	try {
		int sender_account_no=this.getAccountNo(usr_name, sendaccountType);
		if(sender_account_no == 0) {
			message="Sender's Account Type does not exists";
			request.setAttribute("message", message);
			request.getRequestDispatcher("Transfer.jsp").forward(request, response);
		}
		if(!checkAccountExists(recaccountType,anum)) {
			message="Receiver's Account does not exists";
			request.setAttribute("message", message);
			request.getRequestDispatcher("Transfer.jsp").forward(request, response);	
		}
		if(sender_account_no!=0 && this.getbalance(sendaccountType, sender_account_no)-withdrawAmn<0 ) {
			message="Balance not sufficient to transfer";
			request.setAttribute("message", message);
			request.getRequestDispatcher("Transfer.jsp").forward(request, response);	
		}
		if(sender_account_no!=0 && checkAccountExists(recaccountType,anum) && this.getbalance(sendaccountType, sender_account_no)-withdrawAmn>=0 ) {
			this.updateAccounts(sendaccountType,sender_account_no,recaccountType,anum,withdrawAmn);
			message="Transfer Successful";
			request.setAttribute("message", message);
			request.getRequestDispatcher("Transfer.jsp").forward(request, response);	
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
	
		public boolean checkAccountExists(String acc_type, int acc_num) throws SQLException {
			Statement stmt;
			String accountTyp = null;
			int accountNum = 0;
			try {
				stmt = DatabaseConnection.getConnection().createStatement();
				ResultSet rs = stmt.executeQuery(
						"select * from NEWACCOUNT where  ACC_TYP = '" + acc_type + "' and ACCOUNTNO = '" + acc_num + "'");
				while (rs.next()) {
					accountTyp = rs.getString(9);
					accountNum = rs.getInt(1);
				}
				if (acc_num == accountNum && acc_type.toUpperCase().equals(accountTyp)) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

	public int getbalance(String acc_type, int acc_num) {
		Statement stmt;
		int amount = 0;
		try {
			stmt = DatabaseConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(
					"select * from NEWACCOUNT where ACC_TYP = '" + acc_type + "' and ACCOUNTNO = '" + acc_num + "'");
			while (rs.next()) {
				amount = rs.getInt(6);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return amount;

	}
	
	public int getAccountNo(String user_name, String acc_type) {
		int AccountNo = 0;
		try {
			Statement stmt;
			stmt = DatabaseConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(
					"select * from NEWACCOUNT where  ACC_TYP = '" + acc_type + "' and USERNAME = '" + user_name + "'");
			while (rs.next()) {
				AccountNo = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AccountNo;
	}
	
	public void updateAccounts(String senderAccType ,int senderAccNo ,String recAccType, int recAccNo , int transfer) {
		try {
			int senderBalance = this.getbalance(senderAccType, senderAccNo) - transfer;
			int receiverBalance = this.getbalance(recAccType, recAccNo) + transfer;

			String queryToUpdateSenderAmount = "Update NEWACCOUNT set AMOUNT = " + senderBalance + " where  ACC_TYP = '"
					+ senderAccType + "' and ACCOUNTNO = '" + senderAccNo + "'";
			PreparedStatement preparedStmtqueryToUpdateAmount = DatabaseConnection.getConnection()
					.prepareStatement(queryToUpdateSenderAmount);
			preparedStmtqueryToUpdateAmount.executeUpdate();

			String queryToUpdateReceiverAmount = "Update NEWACCOUNT set AMOUNT = " + receiverBalance
					+ " where  ACC_TYP = '" + recAccType + "' and ACCOUNTNO = '" + recAccNo + "'";
			PreparedStatement preparedStmtqueryToUpdateReceiverAmount = DatabaseConnection.getConnection()
					.prepareStatement(queryToUpdateReceiverAmount);
			preparedStmtqueryToUpdateReceiverAmount.executeUpdate();

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}