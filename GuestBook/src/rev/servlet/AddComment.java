package rev.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rev.model.GuestBookEntry;

@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
 int idSeed = 100;
	public AddComment() {
		super();

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
        out.println("<html><head><title>EditComment</title></head><body>");
        out.println("<form action='AddComment' method = 'post'>");
        out.println("Name: <input type='text' name = 'name' > <br />");
        out.println("<textarea name = 'message' ows='5' cols='60' '></textarea> <br />");
      
        out.println("<input type = 'submit' name = 'add' value = 'Add'> <br />");
        out.println("</form>");
        out.println("</body></html>");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String message = request.getParameter("message");
	
		List<GuestBookEntry> entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		
		entries.add(new GuestBookEntry(idSeed++,name, message));
		
		response.sendRedirect("GuestBook");
	}

}
