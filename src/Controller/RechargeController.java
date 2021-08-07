package Controller;
import Model.*;
import java.util.Date;
import Dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RechargeController
 */
@WebServlet("/RechargeController")
public class RechargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechargeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String msg=null;
		RechargeDao dao=new RechargeDao();
		String mobno=request.getParameter("mobile");
		String amt=request.getParameter("amount");
		String operator=request.getParameter("service");
		HttpSession ses=request.getSession(true);
		String usr=(String)ses.getAttribute("login");
		System.out.println("on recharge  "+usr);
		Recharge rg=new Recharge(usr,mobno,amt,operator,new Date());

		int amt2=Integer.parseInt(amt);
		int oldbal=dao.returnbal(usr);
		int newbal=oldbal-amt2;
		if(amt2>oldbal)
		{
			msg="fail recharge";
			ses.setAttribute("rech",msg);
			response.sendRedirect("Recharge.jsp");
		}
		else {
			String upbal=String.valueOf(newbal);
			dao.updateBal(usr, upbal);
			int i=dao.recharge(rg);
			if(i==1)
			{
				msg="Done recharge";
				ses.setAttribute("recharge",msg);
				response.sendRedirect("Recharge.jsp");
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
