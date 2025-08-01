package com.tourtales.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tourtales.user.*;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pass");
		
		System.out.println(email);
		System.out.println(pwd);
		
		User user = UserDBUtil.validate(email, pwd);
		
		if (user.getId() != 0) {
			HttpSession session = request.getSession();
            session.setAttribute("user", user);
    		response.sendRedirect("profile");
		} else {
			request.setAttribute("errorMessage", "invalid");
			doGet(request, response);
		}
		
	}

}
