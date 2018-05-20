package rev.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rev.model.GuestBookEntry;

@WebServlet("/DeleteEntry")
public class DeleteEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteEntry() {
		super();

	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		Integer index = Integer.parseInt(request.getParameter("index"));
		
		for( GuestBookEntry entry : entries )
            if( entry.getId().equals( index ) )
            {
                entries.remove( entry );
                break;
            }

		
		response.sendRedirect("GuestBook");
	}

	

}
