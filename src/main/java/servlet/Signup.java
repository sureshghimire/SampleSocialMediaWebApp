package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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


@WebServlet("/signup")
public class Signup extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getRequestDispatcher("Signup.jsp").forward(req, resp);
		//NOTE: Filter will not work 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String username= req.getParameter("username");
		String password = req.getParameter("password");
		String email= req.getParameter("email");
		int phoneNum =Integer.parseInt(req.getParameter("phoneNumber"));
		String adddress = req.getParameter("address");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhoneNum(phoneNum);
		user.setAddress(adddress);
		
		//add user obj to the users list
		List<User> users = new ArrayList<>();
		users.add(user);
		
		req.setAttribute("userList", users);
		
		Db service = new Db();
		service.addUser(user);
		service.close();
		
		
		
//		
//		//	Add to database	
//		
//		String url = "jdbc:mysql://localhost:3306/sample_db";
//	     String userid = "root";
//	     String pass = "1234";
//	     Connection conn;
//	     
//	     try {
//			//load driver
//	    	 Class.forName("com.mysql.cj.jdbc.Driver");
//			
//	    	 
//	    	 //create connection
//	    	 conn= DriverManager.getConnection(url,userid,pass);
//	    	 
//	    	 //Insert Syntax
//	    	 String insert = "insert into users(username,email,password,phone,address) values(?,?,?,?,?)";
//	    	 
//	    	 //Insert Statement
//	    	 PreparedStatement pst = conn.prepareStatement(insert);
//	    	 pst.setString(1, user.getUsername());
//	    	 pst.setString(2, user.getEmail());
//	    	 pst.setString(3, user.getPassword());
//	    	 pst.setInt(4, user.getPhoneNum());
//	    	 pst.setString(5, user.getAddress());
//	    	
//	    	 pst.executeUpdate();
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	     //req.getRequestDispatcher("UserList.jsp").forward(req, res);
	    res.sendRedirect("userList");
		
	   
	}
}
