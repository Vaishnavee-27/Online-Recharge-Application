package Controller;
import Model.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.*;
/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses=request.getSession(true);
		HttpSession ses2=request.getSession(true);

		String m=null;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Logins l=new Logins();
		l.setUsername(username);
		l.setPassword(password);
		RegisterDao rdao=new RegisterDao();
		int b=rdao.validateUser(l);
		if(b==1)
		{		
			ses.setAttribute("login", username);
			response.sendRedirect("Dashboard.jsp");
		}
		else
		{
			m="Not registered";
			ses2.setAttribute("log", m);
			response.sendRedirect("Login.jsp");
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
