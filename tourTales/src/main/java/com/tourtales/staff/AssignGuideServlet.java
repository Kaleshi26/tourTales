package com.tourtales.staff;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourtales.main.Booking;
import com.tourtales.user.TourGuide;
import com.tourtales.user.UserDBUtil;

/**
 * Servlet implementation class AssignGuideServlet
 */
@WebServlet(name = "assign-guide", urlPatterns = { "/assign-guide" })
public class AssignGuideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignGuideServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TourGuide> guides =  UserDBUtil.getAllGuides();
		Integer booking_id = Integer.valueOf(request.getParameter("id"));
		
		request.setAttribute("tourGuides", guides);
		request.setAttribute("id", booking_id);
		request.getRequestDispatcher("/assign-guide.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer guide_id = Integer.valueOf(request.getParameter("guide-id"));
		Integer booking_id = Integer.valueOf(request.getParameter("id"));
		Booking booking = BookingDB.getBooking((int) booking_id);

		booking.updateGuideId(guide_id);
		response.sendRedirect("verify-booking?id=" + booking_id);
	}

}
