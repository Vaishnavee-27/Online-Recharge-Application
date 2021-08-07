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
 * Servlet implementation class UpdateController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msg=null;
		
		HttpSession ses=request.getSession(true);
		String usr=(String)ses.getAttribute("login");
		System.out.println("on edit "+usr);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobno=request.getParameter("mobile");
		String balance=request.getParameter("balance");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Customer s=new Customer(name, email, mobno, balance, username, password);
		ProfileDao pd=new ProfileDao();
		int k=pd.UpdateProfile(s,usr);
		if(k>0)
		{
			msg="done profile";
			ses.setAttribute("profiles", msg);
			response.sendRedirect("profile.jsp");
		}
		else
		{
			response.sendRedirect("EditProfile.jsp");
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
