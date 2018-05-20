package rev.controller.copy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rev.model.GuestBookEntry;


@WebServlet("/EditEntry2")
public class EditEntry2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditEntry2() {
        super();
       
    }
    public GuestBookEntry getEntry(Integer index){
    	
    	List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
    	
    	for(GuestBookEntry entry : entries){
    		if(entry.getId().equals(index))
    		return entry;
    	}
    	return null;
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer index = Integer.parseInt(request.getParameter("index"));
		GuestBookEntry entry = getEntry(index);
		
		response.setContentType("text/html");
		PrintWriter out  = response.getWriter();
		out.println("<html><head><title>EditComment</title></head><body>");
		out.println("<form action='EditEntry2' method = 'post'>");
		out.println("Name: <input type='text' name = 'name' value= '"+entry.getName()+"'> <br />");
		out.println("<textarea name = 'message' ows='5' cols='60'>"+entry.getMessage()+"</textarea> <br />");
		out.println("<input type='hidden' name = 'index' value= '"+entry.getId()+"'>");
		out.println("<input type = 'submit' name = 'add' value = 'Add'> <br />");
		out.println("</form>");
		out.println("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name =  request.getParameter("name");
		String message  = request.getParameter("message");
		Integer index = Integer.parseInt(request.getParameter("index"));
		
		GuestBookEntry entry = getEntry(index);
		entry.setName(name);
		entry.setMessage(message);
		response.sendRedirect("GuestBook2");
		
	}

}
