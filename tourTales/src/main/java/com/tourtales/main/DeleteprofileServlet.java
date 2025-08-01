package com.tourtales.main;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tourtales.user.User;

import models.DBconnection;

@WebServlet("/DeleteprofileServlet")
public class DeleteprofileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	
		
		User user = (User) session.getAttribute("user");
		int Id=0;
		
		if (user != null) {
           
             Id = user.getId();
		}
		else
		{
			System.out.println("no user");
		}
           
		
			try {
				
				Connection con = DBconnection.getconnection();
				Statement st = con.createStatement();
				String sql ="delete from User where user_id="+Id;
				int rs = st.executeUpdate(sql);
				
				if(rs == 1)
				{
					System.out.println("deleted");
					session.invalidate();
		            response.sendRedirect("login"); 
				}
				 
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}

	}

}
