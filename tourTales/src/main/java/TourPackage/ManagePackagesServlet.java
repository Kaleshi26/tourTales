package TourPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "manage-packages", urlPatterns = { "/manage-packages" })
public class ManagePackagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    PackageDBUtil pdb = new PackageDBUtil();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<T_Package> tpList = pdb.getAllPPackages();
        request.setAttribute("pkg", tpList);
        RequestDispatcher rd = request.getRequestDispatcher("manage-packages.jsp");
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
