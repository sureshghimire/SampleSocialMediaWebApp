package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.Db;


@WebServlet("/editUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private User getUser(int id) {
		//Get Users list from the servlet
		List<User>users = (List<User>) getServletContext().getAttribute("usersList");
		for(User user: users) {
			if(id==user.getId())
				return user;
		}
		
		return null;
	}
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id_string = req.getParameter("id");
		int id = Integer.parseInt(id_string);
		
		User user = getUser(id);
		
	 
		getServletContext().setAttribute("updateUser", user);
		req.getRequestDispatcher("EditUser.jsp").forward(req, res);
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		User user = (User) getServletContext().getAttribute("updateUser");
		
		String username= req.getParameter("username");
		String password = req.getParameter("password");
		String email= req.getParameter("email");
		int phoneNum =Integer.parseInt(req.getParameter("phoneNumber"));	
		String adddress = req.getParameter("address");
		
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhoneNum(phoneNum);
		user.setAddress(adddress);
		
		
		Db service = new Db();
		service.updateUser(user);
		service.close();
	
   	 	res.sendRedirect("userList");
   	 	
	}
	

}
