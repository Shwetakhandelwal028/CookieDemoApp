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
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		
		Cookie  ck[] = request.getCookies();
		if(ck != null) {
			String uname = ck[0].getValue();
			String email = ck[1].getValue();
			String password = ck[2].getValue();
			 
			request.getRequestDispatcher("navigate.html").include(request, response);
				out.print("<h3>Welcome to Profile </h3> ");
				out.print("<h3>Welcome , "+ uname +"</h3>");
				out.print("<h3>Your credential details are : </h3>");
				out.print("<h3>Email  "+ email +"</h3>");
				out.print("<h3>Password  "+ password +"</h3>");
				
				
			
		} else {
			out.print(" Please Register First ! ");
			request.getRequestDispatcher("registration.html").include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
