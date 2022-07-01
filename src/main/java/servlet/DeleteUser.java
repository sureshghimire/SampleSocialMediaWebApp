package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/delUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_string = request.getParameter("id");
		int id = Integer.parseInt(id_string);
		
		
		
//		Add to database	
		
			String url = "jdbc:mysql://localhost:3306/sample_db";
		     String userid = "root";
		     String pass = "1234";
		     Connection conn;
		     
		     try {
				//load driver
		    	 Class.forName("com.mysql.cj.jdbc.Driver");
				
		    	 
		    	 //create connection
		    	 conn= DriverManager.getConnection(url,userid,pass);
		    	 
		    	 //Insert Syntax
		    	 String del = "delete from users where id=?";
		    	 
		    	 //Insert Statement
		    	 PreparedStatement pst = conn.prepareStatement(del);
		    	 pst.setInt(1,id);
		   		    	
		    	 pst.executeUpdate();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		     
		     response.sendRedirect("userList");
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
