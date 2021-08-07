package Controller;
import Model.*;
import Dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(true);
		String msg=null;
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobno=request.getParameter("mobno");
		String balance=request.getParameter("balance");
		//String bal=String.valueOf(balance);
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Customer s=new Customer(name, email, mobno,balance, username, password);
		RegisterDao rdao=new RegisterDao();
		int i=rdao.checkuser(s);
		if(i>0){
			msg="Username & Password already Exist";
			session.setAttribute("reg2", msg);
			response.sendRedirect("Register.jsp");
		}else
		{
			int j=rdao.create(s);
			if(j>0)
			{
				session.setAttribute("reg", username);
				response.sendRedirect("Login.jsp");
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
