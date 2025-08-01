package TourPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "delete-package", urlPatterns = { "/delete-package" })
public class DeletePackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    PackageDBUtil pdb = new PackageDBUtil();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("id"));
        pdb.deletePackage(pid);
        response.sendRedirect("manage-packages");
	}

}
