package TourPackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "add_package", urlPatterns = { "/add_package" })
public class AddPackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    PackageDBUtil pdb = new PackageDBUtil();

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("Add_package.jsp");
        rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String packName = request.getParameter("pname");
        String type = request.getParameter("ptype");
        int days = Integer.parseInt(request.getParameter("days"));
        double budget = Double.parseDouble(request.getParameter("budget"));

        T_Package pk = new T_Package(packName, type, days, budget);
        pdb.addNewPackage(pk);

        response.sendRedirect("manage-packages");
	}

}
