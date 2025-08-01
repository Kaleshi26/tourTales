package com.tourtales.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "delete-message", urlPatterns = { "/delete-message" })
public class DeleteMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer msg_id = Integer.parseInt(request.getParameter("msg-id"));
		System.out.println(msg_id);
		MessageDBUtil.deleteMessage(msg_id);
		response.sendRedirect("messages");
	}

}
