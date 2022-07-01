package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.Db;

@WebServlet("/userList")
public class UserList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Add to database	
		
		//List<User>users = new ArrayList<>();
		
		
		Db service = new Db();
		List <User> users = service.getAllUsers();
		
		service.close();
		
//			String url = "jdbc:mysql://localhost:3306/sample_db";
//		     String userid = "root";
//		     String pass = "1234";
//		     Connection conn;
//		     
//		     try {
//				//load driver
//		    	 Class.forName("com.mysql.cj.jdbc.Driver");
//				
//		    	 
//		    	 //create connection
//		    	 conn= DriverManager.getConnection(url,userid,pass);
//		    	 
//		    	 //Insert Syntax
//		    	 String selectAll = "select *from users";
//		    	 
//		    	 //Insert Statement
//		    	 PreparedStatement pst = conn.prepareStatement(selectAll);
//		    	 ResultSet rs = pst.executeQuery();
//		    	 
//		    	 while(rs.next()) {
//		    		 User user = new User();
//		    		 user.setId(rs.getInt("id"));
//		    		 user.setUsername(rs.getString("username"));
//		    		 user.setPassword(rs.getString("password"));
//		    		 user.setEmail(rs.getString("email"));
//		    		 user.setPhoneNum(rs.getInt("phone"));
//		    		 user.setAddress(rs.getString("address"));
//		    		 
//		    		 users.add(user);
//		    		 
//		    	 }
//		    	 
//		    	
//		    	 conn.close();
//				
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		     //req.setAttribute("users", users);
		     getServletContext().setAttribute("usersList", users);
		     req.getRequestDispatcher("UserList.jsp").forward(req, resp);;
	}
}
