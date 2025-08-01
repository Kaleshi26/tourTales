 package com.tourlist;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class tourguideinsert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tourtitle = request.getParameter("tourtitle");
        String packagename = request.getParameter("name");
        String tourcount = request.getParameter("count");
        String category = request.getParameter("category");
        String language = request.getParameter("language");
        String email = request.getParameter("email");
        String contactnumber = request.getParameter("contact_number");
        String registrationnumber = request.getParameter("registration_number");
        String description = request.getParameter("description");
        String duration = request.getParameter("duration");
        String price = request.getParameter("price");

        request.setAttribute("tourtitle", tourtitle);
        request.setAttribute("name", packagename);
        request.setAttribute("count", tourcount);
        request.setAttribute("category", category);
        request.setAttribute("language", language);
        request.setAttribute("email", email);
        request.setAttribute("contact_number", contactnumber);
        request.setAttribute("registration_number", registrationnumber);
        request.setAttribute("description", description);
        request.setAttribute("duration", duration);
        request.setAttribute("price", price);

        boolean isTrue; 

        isTrue = tourlistDBUtil.inserttourlist(tourtitle, packagename, tourcount, category, language, email, contactnumber, registrationnumber, description, duration, price);

        if (isTrue == true) {
            RequestDispatcher dis = request.getRequestDispatcher("/tourlist.jsp");
            dis.forward(request, response);
        } else {
            RequestDispatcher dis2 = request.getRequestDispatcher("/unsuccessTG.jsp");
            dis2.forward(request, response);
        }
    }
}
