package com.tourtales.user;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserUtils {
	public static void setDashboardTabs(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Map<String, String> tabs = new LinkedHashMap<String, String>();
		tabs.put("Dashboard", "profile");
		tabs.put("Messages", "messages");

		if (user.getPermission().equals("ADM") || user.getPermission().equals("STF")) {
			tabs.put("New Bookings", "new-bookings");
		} else if (user.getPermission().equals("TG")) {
			tabs.put("Tour list", "tourlist.jsp");
		} else if (user.getPermission().equals("CUS")) {
			tabs.put("Bookings", "Bookings");
		} 
		
		if (user.getPermission().equals("ADM")) {
			tabs.put("Manage packages", "manage-packages");
		}

		request.setAttribute("tabs", tabs);
	}

	// check if logged in and if not redirect to the login page
	public static boolean checkIfLoggedIn(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("user") == null) {
			return false;
		} else {
			return true;
		}
	}
}
