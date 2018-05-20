package rev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rev.model.GuestBookEntry;

/**
 * Servlet implementation class GuestBook1
 */
@WebServlet(urlPatterns = "/GuestBook1", loadOnStartup = 1)
public class GuestBook1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    public GuestBook1() {
      
    }

    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
		entries.add(new GuestBookEntry(1, "John", "Revise things fast"));
		entries.add(new GuestBookEntry(2, "Harman", "Need to work on java a lot"));
		entries.add(new GuestBookEntry(3, "Harpreet Aunt", "Harman waste a lot of time doing nothing"));
		entries.add(new GuestBookEntry(4, "Rani Aunt", "Harman is a sau bacha"));

		getServletContext().setAttribute("entries", entries);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/GuestBook1.jsp").forward(request, response);
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
