package TourPackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdatePackageServlet
 */
@WebServlet(name = "update-package", urlPatterns = { "/update-package" })
public class UpdatePackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    PackageDBUtil pdb = new PackageDBUtil();


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		T_Package oldPackage = pdb.selectOldPackage(id);
		RequestDispatcher rd = request.getRequestDispatcher("UpdatePack.jsp");
		request.setAttribute("pk", oldPackage);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        String packName = request.getParameter("pname");
        String type = request.getParameter("ptype");
        int days = Integer.parseInt(request.getParameter("days"));
        double budget = Double.parseDouble(request.getParameter("budget"));

        T_Package updatedPackage = new T_Package(pid, packName, type, days, budget);

        boolean check = pdb.updateOldPackage(updatedPackage);

        if (check) {
            response.sendRedirect("manage-packages");
        } else {
            System.out.println("Failed to update");
        }
	}

}
