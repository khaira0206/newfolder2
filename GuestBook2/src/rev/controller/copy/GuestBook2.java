package rev.controller.copy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rev.model.GuestBookEntry;


@WebServlet(urlPatterns = "/GuestBook2", loadOnStartup = 1)
public class GuestBook2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public GuestBook2() {
    
    }
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	 try
         {
             Class.forName( "com.mysql.jdbc.Driver" );
         }
         catch( ClassNotFoundException e )
         {
             throw new ServletException( e );
         }
    }
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();

		
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://localhost/khaira";
            String username = "khaira";
            String password = "root";

             c = DriverManager
                .getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from guestbook" );

            while( rs.next() )
            {
            	
            	GuestBookEntry entry = new GuestBookEntry(
            			rs.getInt( "id" ),
            			rs.getString("name"),
            			rs.getString("message"));
            	entries.add(entry);
                
            
            }

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
        request.setAttribute("entries", entries);
        request.getRequestDispatcher("/WEB-INF/GuestBook2.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
