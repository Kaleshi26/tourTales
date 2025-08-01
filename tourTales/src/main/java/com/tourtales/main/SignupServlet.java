package com.tourtales.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tourtales.user.User;
import com.tourtales.user.UserDBUtil;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet(name = "signup", urlPatterns = { "/signup" })
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname"); 
		String email = request.getParameter("email").stripTrailing(); 
		String dob = request.getParameter("dob"); 
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		String contact = request.getParameter("contact");

		
		if (UserDBUtil.insertNewUser(fname, lname, email, password, contact, dob, country, "CUS")) {
			response.sendRedirect("profile");
			User user = UserDBUtil.getlatestUser();
			HttpSession session = request.getSession();
            session.setAttribute("user", user);
		} else {
			doGet(request, response);
		}
	}

}
