package rev.servlet;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rev.model.GuestBookEntry;

@WebServlet(urlPatterns = "/GuestBook", loadOnStartup = 2)
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GuestBook() {

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

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		out.println("<html><head><title>GuestBook</title></head>");
		out.println("<h2>Guest Book</h2>");
		out.println("<table border='1'>");
		for (int i = 0; i < entries.size(); i++) {
			GuestBookEntry entry = entries.get(i);
			out.println("<tr><td>" + entry.getName() + ":says</td><td>" + entry.getMessage()
					+ "</td><td><a href='EditEntry?index=" + entry.getId() + "'>Edit</td><td><a href='DeleteEntry?index="
					+ entry.getId() + "'>Delete</td></tr>");
		}
		out.println("</table></body></html>");
		out.println("<a href='AddComment'>Send Message</a>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
