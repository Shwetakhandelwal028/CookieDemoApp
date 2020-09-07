package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("registration.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("navigate.html").include(request, response);
		String userName= request.getParameter("userName");
		String email = request.getParameter("email");
		String password= request.getParameter("password");
		String cnfPassword= request.getParameter("cnfpassword");
		
		if(userName.isEmpty() || email.isEmpty() || password.isEmpty() || cnfPassword.isEmpty() ) {
			out.print("None of the field should be empty !");
			
		}else if(!password.equals(cnfPassword)) {
			out.print("Password and Confirm Password should be same !");
			
		}
		else {
			out.println("You are successfully registered !");
			out.println("Welcome User : "+ userName);
			
			// create cookie
			Cookie ck1 = new Cookie("uname", userName);
			Cookie ck2 = new Cookie("uemail", email);
			Cookie ck3 = new Cookie("upassword", password);
			response.addCookie(ck1);
			response.addCookie(ck2);
			response.addCookie(ck3);
			
		}
	}

}
