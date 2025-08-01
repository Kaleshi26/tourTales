package com.tourtales.main;
import models.Packages;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.DBconnection;

@WebServlet("/tour-packages")
public class PackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Packages> packagelist = new ArrayList<>();
		
		try {
			
			Connection con = DBconnection.getconnection();
			Statement st = con.createStatement();
			String query = "SELECT Pid,Pname FROM Package";
			ResultSet rs= st.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println("Successs");
				int packageid = rs.getInt("Pid");
				String packagename = rs.getString("Pname");
				
				
				Packages pack = new Packages(packageid, packagename);
				
				packagelist.add(pack);
				
			}
			
			System.out.println(packagelist);
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// Pass the vehicle list to the JSP page
        request.setAttribute("packagelist",packagelist); //list of selected packages
        
        System.out.println(packagelist.size());
        RequestDispatcher dispatcher = request.getRequestDispatcher("packages.jsp");
        dispatcher.forward(request, response);
        System.out.println(packagelist);
        
        
        request.setAttribute("packagelist",packagelist);
       RequestDispatcher dispatcher2 = request.getRequestDispatcher("payment.jsp");
       dispatcher2.forward(request, response);
        
        
	}
}
	