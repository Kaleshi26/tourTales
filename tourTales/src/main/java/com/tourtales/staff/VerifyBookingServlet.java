package com.tourtales.staff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourtales.main.Booking;
import com.tourtales.main.Payment;
import com.tourtales.main.PaymentUtils;
import com.tourtales.user.TourGuide;
import com.tourtales.user.User;
import com.tourtales.user.UserDBUtil;
import com.tourtales.user.UserUtils;

/**
 * Servlet implementation class VerifyBookingServlet
 */
@WebServlet(name = "verify-booking", urlPatterns = { "/verify-booking" })
public class VerifyBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!UserUtils.checkIfLoggedIn(req, resp)) {
			resp.sendRedirect("login");
			return;
		}
		super.service(req, resp);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer booking_id = Integer.valueOf(request.getParameter("id"));
		Booking booking = BookingDB.getBooking((int) booking_id);
		User customer = UserDBUtil.getCustomer(booking.getCusid());
		Payment payment = PaymentUtils.getPayment(booking.getPayid());

		if (booking.getGuide_id() != null) {
			TourGuide guide = UserDBUtil.getTourGuide(booking.getGuide_id());
			request.setAttribute("guide", guide);
		}
		request.setAttribute("payment", payment);
		request.setAttribute("customer", customer);
		request.setAttribute("booking", booking);
		request.getRequestDispatcher("/verify-booking.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer booking_id = Integer.valueOf(request.getParameter("id"));
		Booking booking = BookingDB.getBooking((int) booking_id);

		String action = request.getParameter("sub");
		System.out.println(action);
		if (action.equals("done")) {
			String verification_status = request.getParameter("verification");
			System.out.println("verification: " + verification_status);
			booking.updateVerifyStatus(verification_status);
			booking.checkBookingStatus();
		} else if (action.equals("cancel")) {
			booking.updateBookingStatus("Cancelled");
		}

		response.sendRedirect("new-bookings");
	}

}
