package rev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rev.model.GuestBookEntry;


@WebServlet("/EditEntry1")
public class EditEntry1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditEntry1() {
        super();
        
    }

    private GuestBookEntry  getEntry(Integer id){
    	
    	List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
    	
    	for(GuestBookEntry entry : entries){
    		
    		if(id.equals(entry.getId())){
    			return entry;
    			
    		}
    	}
    	return null;
    	
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer index = Integer.parseInt(request.getParameter("index"));
        GuestBookEntry entry = getEntry(index);
        
        request.setAttribute("entry", entry);
        request.getRequestDispatcher("/WEB-INF/EditEntry1.jsp").forward(request, response);
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Integer id = Integer.parseInt(request.getParameter("index"));
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		GuestBookEntry entry = getEntry(id);
		entry.setName(name);
		entry.setMessage(message);
		response.sendRedirect("GuestBook1");
		
		
	}

}
