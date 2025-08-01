package com.tourtales.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MessgeServlet
 */
@WebServlet(name = "messages", urlPatterns = { "/messages" })
public class MessgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (!UserUtils.checkIfLoggedIn(req, res)) {
			res.sendRedirect("login");
			return;
		}
		UserUtils.setDashboardTabs(req);		
		super.service(req, res);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		User user = (User) session.getAttribute("user"); 
		
		ArrayList<Message> messages = MessageDBUtil.getMessages(user.getId());
		
		request.setAttribute("messages", messages);
		request.getRequestDispatcher("/messages.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		User user = (User) session.getAttribute("user"); 
		
		String type = request.getParameter("type");
		if (type.equals("delete")) {
			Integer msg_id = Integer.parseInt(request.getParameter("msg-id"));
			System.out.println(msg_id);
			MessageDBUtil.deleteMessage(msg_id);
		} else if (type.equals("new")) {
			String email = request.getParameter("email");
			String msg = request.getParameter("new-message");
			int receiver_id = UserDBUtil.getIdFromEmail(email);
			Message message = new Message(0, user.getId(), receiver_id, msg, user.getEmail());
			message.insertNewMessage();
		}
		doGet(request, response);
	}

}
