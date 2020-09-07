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
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		
		Cookie  ck[] = request.getCookies();
		if(ck != null) {
			String userName = ck[0].getValue();
			String email = ck[1].getValue();
			String password = ck[2].getValue();
			
			if(userName.equals(request.getParameter("userName")) && password.equals(request.getParameter("password"))) {
				request.getRequestDispatcher("navigate.html").include(request, response);
				out.println("You are successfully Logged In !");
				out.println("Welcome : "+ userName);
				
				
			}else {
				out.println("Invalid Credentials !");
				request.getRequestDispatcher("login.html").include(request, response);
			}
		} else {
			out.print(" Please Register First ! ");
			request.getRequestDispatcher("registration.html").include(request, response);
		}
	}

}
