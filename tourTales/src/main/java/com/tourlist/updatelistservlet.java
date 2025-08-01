package com.tourlist;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class updatelistservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String listID =request.getParameter("listID");
		String tourtitle = request.getParameter("tourtitle");
		String packagename = request.getParameter("name");
		String tourcount = request.getParameter("count");
		String category = request.getParameter("category");
		String language = request.getParameter("language");
		String email = request.getParameter("email");
		String contactnumber = request.getParameter("contact_number");
		String registrationnumber = request.getParameter("registration_number");
		String description = request.getParameter("description");
		String duration = request.getParameter("duration");
		String price = request.getParameter("price");
		
		boolean isTrue;
		
		isTrue = tourlistDBUtil.updatelist(listID,tourtitle, packagename, tourcount, category, language, email, contactnumber, registrationnumber, description, duration, price);
		
		if(isTrue == true) {
			
			List<list>  listDetails = tourlistDBUtil.getlistDetails(listID);
			request.setAttribute("listDetails", listDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("guidedetails.jsp");
			dis.forward(request, response);
			
		}
		else {
			
			List<list>  listDetails = tourlistDBUtil.getlistDetails(listID);
			request.setAttribute("listDetails", listDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("guidedetails.jsp");
			dis.forward(request, response);
		}
	
	}

}
