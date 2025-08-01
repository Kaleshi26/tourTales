package com.tourtales.staff;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tourtales.main.Booking;
import com.tourtales.user.User;
import com.tourtales.user.UserUtils;

/**
 * Servlet implementation class NewBookingServlet
 */
@WebServlet(name = "new-bookings", urlPatterns = { "/new-bookings" })
public class NewBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!UserUtils.checkIfLoggedIn(req, resp)) {
			resp.sendRedirect("login");
			return;
		}
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user == null || !(user.getPermission().equals("STF") || user.getPermission().equals("ADM"))) {
			resp.sendRedirect("login");
			return;
		}
		
    	super.service(req, resp);

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Booking> bookings =  BookingDB.getNewBookings();
		UserUtils.setDashboardTabs(request);
		request.setAttribute("bookings" , bookings);
		request.getRequestDispatcher("/new-bookings.jsp").forward(request, response);
	}

}
