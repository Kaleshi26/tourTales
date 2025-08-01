package com.tourtales.main;
 import com.tourtales.user.User;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Bookings;
import models.DBconnection;
import models.Vehiclemodel;

@WebServlet("/Bookings")
public class BookingsServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet method triggered!");
		
		List<Bookings> bookings = new ArrayList<>();
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
			String sql = "SELECT * FROM Booking where cusid="+Id;
			ResultSet rows = st.executeQuery(sql);
			
			
			while(rows.next())	
				
				
			{
				System.out.println("retrival Successs");
				int id = rows.getInt("booking_id");
				String pickup = rows.getString("Pickup_loc");
				int number = rows.getInt("no_of_participants");
				String verify = rows.getString("Verification");
				int pid = rows.getInt("pid");
				
				Bookings currentbooking = new Bookings(id, pickup, number, verify,pid);
				bookings.add(currentbooking);

			}
			
			con.close();
	
		       
		    } catch (Exception e) 
				{
		        e.printStackTrace();
		    }

				request.setAttribute("bookings",bookings); 
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("BookingDashboard.jsp");
				dispatcher.forward(request, response);
		
		
		
	}

	
}
