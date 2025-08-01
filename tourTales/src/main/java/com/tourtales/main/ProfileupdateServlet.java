package com.tourtales.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
import com.tourtales.user.UserDBUtil;

import models.DBconnection;

@WebServlet("/ProfileupdateServlet")
public class ProfileupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User currentuser = null;
		
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
				String sql ="select * from User where user_id="+Id;
				ResultSet rs = st.executeQuery(sql);
				
				String firstname ;
				String lastname ;
				String mail ;
				String pass ;
				String contact;
				String date;
				String countryy;
				
				if(rs.next())
				{
				
					 firstname = rs.getString("fname");
					 lastname = rs.getString("lname");
					 mail = rs.getString("email");
					 pass = rs.getString("pwd");
					 contact = rs.getString("contact_no");
					 date = rs.getString("dob");
					 countryy = rs.getString("country");
					 String permission = rs.getString("permission_level");
					 
					 currentuser = new User(Id,firstname,lastname,mail,pass,contact,date,countryy, permission);
				}
				 
				
			
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			
			request.setAttribute("userdetails",currentuser);	
			RequestDispatcher dispatcher = request.getRequestDispatcher("ProfileUpdate.jsp");
			dispatcher.forward(request, response);		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String contact = request.getParameter("contact");
		String date = request.getParameter("dob");
		String country = request.getParameter("country");

		
		try {
			Connection con = DBconnection.getconnection();
			
		    Statement stmt1 = con.createStatement();
		    String sql ="UPDATE User SET fname='" + fname + "', lname='" + lname + "', email='" + email + "', pwd='" + pass + "', contact_no='" + contact + "', dob='" + date + "', country='" + country + "' WHERE user_id=" + id;
	
		    int rs = stmt1.executeUpdate(sql);
		    
		    //refreshing the session with updated details
		    User updatedUser = UserDBUtil.getUser(id);
			
			if(rs == 1)
				
			{
				HttpSession session = request.getSession();
	            session.setAttribute("user", updatedUser);
				System.out.println("Update sucessfull");
						
			}
			else
			{
				System.out.println("Update Unsucessfull");
			}
			
			
			
		}catch (Exception e) {
				
				e.printStackTrace();
			}
			
		response.sendRedirect("profile");
	}

}
