package rev.controller;

import rev.model.GuestBookEntry;
import java.io.IOException;
import java.util.List;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;


@WebServlet("/DeleteEntry1")
public class DeleteEntry1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteEntry1() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    List<GuestBookEntry> entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
      Integer index = Integer.parseInt(request.getParameter("endex"));
      
      for(GuestBookEntry entry: entries){
    	if(entry.getId().equals(index)){
    		entries.remove(entry);
    		break;
    		
    	}  
    	
      }
      response.sendRedirect("GuestBook1");
	}

	
}
