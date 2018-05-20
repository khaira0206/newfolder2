package rev.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

import rev.model.Employee;
import rev.model.GuestBookEntry;


@WebServlet("/ShowEmployee")
public class ShowEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ShowEmployee() {
        super();
       
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
		
		request.getRequestDispatcher("/WEB-INF/EmployeeForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Employee> employees = new ArrayList<Employee>();
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		
		String sql = "select * from employees1 where name = ? and passwd = ?";
		
		
		
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://localhost/khaira";
            String username = "khaira";
            String password = "root";

             c = DriverManager
                .getConnection( url, username, password );
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, passwd);
            ResultSet rs = stmt.executeQuery();

            while( rs.next() )
            {
            	Employee employee = new Employee(
            			rs.getInt( "id" ),
            			rs.getString("name"),
            			rs.getString("passwd"), 
            			rs.getDate("birthday"),
            			rs.getDouble("salary"));
            	 System.out.println(rs.getString("name"));
            	employees.add(employee);
                
            
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
       
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/WEB-INF/EmployeeInfo.jsp").forward(request, response);
		
		
	}

}
