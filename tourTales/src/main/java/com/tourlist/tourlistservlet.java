package com.tourlist;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/tour-login")
public class tourlistservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String registrationnumber = request.getParameter("registrationnumber");
		

		try {
		List<list> listDetails = tourlistDBUtil.validate(registrationnumber);
		request.setAttribute("listDetails",listDetails);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("guidedetails.jsp");
		dis.forward(request,response);
	}

}
