package rev.controller.copy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rev.model.GuestBookEntry;


@WebServlet("/AddComment2")
public class AddComment2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 int idSeed = 1000;    
    
    public AddComment2() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
        out.println("<html><head><title>EditComment</title></head><body>");
        out.println("<form action='AddComment2' method = 'post'>");
        out.println("Name: <input type='text' name = 'name' > <br />");
        out.println("<textarea name = 'message' ows='5' cols='60' '></textarea> <br />");
      
        out.println("<input type = 'submit' name = 'add' value = 'Add'> <br />");
        out.println("</form>");
        out.println("</body></html>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String message  = request.getParameter("message");
		
List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();

		
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://localhost/khaira";
            String username = "khaira";
            String password = "root";

             c = DriverManager
                .getConnection( url, username, password );
            String sql = "insert into guestbook (name , message) values(? ,?)";
            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, message);
            
            pstmt.executeUpdate();

            

            c.close();
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
        	try{
        		if(c != null) c.close();
        	}catch(SQLException e){
        		throw new ServletException();
        	}
        	
        }
		response.sendRedirect("GuestBook2");
	}

}
