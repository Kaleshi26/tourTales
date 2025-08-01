package com.tourtales.main;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

import models.DBconnection;
import models.Vehiclemodel;


@WebServlet("/Payment")
public class PaymentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		 
		Date date = Date.valueOf(request.getParameter("date"));
		String location = request.getParameter("location");
		int number = Integer.parseInt(request.getParameter("number")); 
		double amount = Double.parseDouble(request.getParameter("amount"));
		LocalDate currentDate = LocalDate.now();
		String paymentMethod = request.getParameter("method");
	    int pid = Integer.parseInt(request.getParameter("pid"));
	    
	    HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int Id=0;
		
		if (user != null) {
           
             Id = user.getId();
		}
		else
		{
			System.out.println("no user");
			response.sendRedirect("login"); 
			return;		
		}
           
            
		
		try {
			
			    Connection con = DBconnection.getconnection();
			    Statement stmt1 = con.createStatement();
			    String sql1 = "INSERT INTO Payment (amount, date) VALUES (" + amount + ", '" + currentDate + "')";

			    int rows1 = stmt1.executeUpdate(sql1,Statement.RETURN_GENERATED_KEYS);
			   
				ResultSet rs = stmt1.getGeneratedKeys();
				
				int key = 0;
				
				if(rs.next())
				{
					key = rs.getInt(1);  
					
							
				}
				
				else
				{System.out.println("error");}
				
				if(paymentMethod != null && paymentMethod.equals("CardPayment"))
				{
					String cardnumber = request.getParameter("cardNumber");
					String cvv = request.getParameter("cvv");
					Statement stmt3 = con.createStatement();
					String sql2 = "INSERT INTO CardPayment (Card_ID, CardNumber, CVV) VALUES (" + key + ", '" + cardnumber + "', '" + cvv + "')";
					int crows = stmt3.executeUpdate(sql2);
					
					if(crows>0) {
						
						System.out.println("Card success");
					}else {System.out.println("error");}
					
				}
				
				Statement stmt = con.createStatement();
				String sql = "INSERT INTO Booking (TourDate, Pickup_loc, no_of_participants, payid, pid, cusid) VALUES ('" + date + "', '" + location + "', " + number + ", " + key + ", " + pid + ", " + Id + ")";

				int rows = stmt.executeUpdate(sql);
				
				if(rows>0)
				{
					System.out.println("Insert Successfull");
					
				}
				else
				{
					System.out.println("error");
				}
				
				
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		response.sendRedirect("Bookings");
     
	    }
		
		
				
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		System.out.println("doGet method");
	    
	    
	    String packageId = (String) request.getParameter("packageId");
	    
	    if(packageId != null)
	    {
	    	System.out.println("id noted");
	    	System.out.println(packageId);
	    }
	    
	    else {System.out.println("no id");}
		
		List<Vehiclemodel> vehicles = new ArrayList<>();
		
		try {
			
			Connection con = DBconnection.getconnection();
			Statement st = con.createStatement();
			String sql = "SELECT vehicle_name, Price_Per_Day, Seat_no FROM vehicle";
			ResultSet rows = st.executeQuery(sql);
			
			
			while(rows.next())	
			{
				System.out.println("Successs");
				String name = rows.getString("vehicle_name");
				
				BigDecimal price = rows.getBigDecimal("Price_Per_Day");
				
				int seats = rows.getInt("Seat_no");
				
				
				Vehiclemodel vehicle = new Vehiclemodel(name,price,seats);
				
				vehicles.add(vehicle);

				
			}
			
			con.close();
	
		       
		    } catch (Exception e) 
				{
		        e.printStackTrace();
		    }
		
		
		
		
		request.setAttribute("vehicles", vehicles); 
		request.setAttribute("packageId", packageId); 

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("payment.jsp");
		dispatcher.forward(request, response); 

		//testing
		System.out.println(vehicles);
		System.out.println(packageId);

}

}
