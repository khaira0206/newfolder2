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


@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditEntry() {
        super();
       
    }
    @SuppressWarnings("unchecked")
    private GuestBookEntry getEntry( Integer id )
    {
        List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute(
            "entries" );

        for( GuestBookEntry entry : entries )
            if( entry.getId().equals( id ) ) return entry;

        return null;
    }
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int index = Integer.parseInt(request.getParameter("index"));
		 GuestBookEntry entry = getEntry( index );
response.setContentType("text/html");
		
PrintWriter out = response.getWriter();
out.println("<html><head><title>EditComment</title></head><body>");
out.println("<form action='EditEntry' method = 'post'>");
out.println("Name: <input type='text' name = 'name' value= '"+entry.getName()+"'> <br />");
out.println("<textarea name = 'message' ows='5' cols='60'>"+entry.getMessage()+"</textarea> <br />");
out.println("<input type='hidden' name = 'index' value= '"+entry.getId()+"'>");
out.println("<input type = 'submit' name = 'add' value = 'Add'> <br />");
out.println("</form>");
out.println("</body></html>");
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		int index = Integer.parseInt(request.getParameter("index"));
	
		GuestBookEntry entry = getEntry( index );
		
		entry.setMessage(message);
		entry.setName(name);		
		response.sendRedirect("GuestBook");
	
	}

}
