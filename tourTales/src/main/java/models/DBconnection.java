package models;

//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;


public class DBconnection{
	
	public static final String url="jdbc:mysql://localhost:3306/tourTales"; 
	public static final String username = "tourTalesAdmin";
	public static final String password = "Admin@1234";
	

	
	public static Connection getconnection() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");   //loading JDBC driver
		
		return DriverManager.getConnection(url,username,password);
		
		
		
	}
	
	
}