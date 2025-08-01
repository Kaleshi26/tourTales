package com.tourlist;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/delete")
public class deletelistservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String listID = request.getParameter("listID");
		boolean isTrue;
		
		isTrue = tourlistDBUtil.deletelist(listID);
		
		if(isTrue == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/tourlist.jsp");
			dispatcher.forward(request, response);
			
		}
		else{
			List<list> listDetails = tourlistDBUtil.getlistDetails(listID);
			request.setAttribute("listDetails", listDetails);

			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
