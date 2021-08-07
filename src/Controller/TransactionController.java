package Controller;
import Dao.*;
import Model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TransactionController
 */
@WebServlet("/TransactionController")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransactionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses=request.getSession(true);
		String str=(String)ses.getAttribute("login");
		System.out.println(str);
		String ch=request.getParameter("choice");
		System.out.println(ch);
		RechargeDao dao=new RechargeDao();
		int bal=dao.returnbal(str);

		String amt=request.getParameter("amount");

		if(ch.equals("withdrawl"))
		{
			TransactionDao td=new TransactionDao();
			int amt2=Integer.parseInt(amt);
			if(amt2>bal)
			{
				String amtw="Amount Withdraw failed";
				ses.setAttribute("with2", amtw);
				response.sendRedirect("Transaction.jsp");
			}
			else {
				int i=td.withdraw(str, amt);
				if(i==1)
				{
					String amtw="Amount Withdraw Successfully";
					ses.setAttribute("with", amtw);
					response.sendRedirect("Transaction.jsp");
				}
				else
				{
					String amtw="Amount Withdraw UnSuccessfully";
					ses.setAttribute("with", amtw);
					response.sendRedirect("Transaction.jsp");
				}
			}
		}

		else
		{
			TransactionDao td=new TransactionDao();
			int i=td.deposit(str, amt);
			if(i==1)
			{
				String amtw="Amount Deposit  Successfully";
				ses.setAttribute("with", amtw);
				response.sendRedirect("Transaction.jsp");
			}
			else
			{
				String amtw="Amount Deposit UnSuccessfully";
				ses.setAttribute("with", amtw);
				response.sendRedirect("Transaction.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
