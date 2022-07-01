package auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.Db;

@WebServlet("/auth")
public class Auth extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		
		
		Db service = new Db();
		User authorizedUser = service.auth(username, pass);
		service.close();
		
		if(authorizedUser !=null) {
			
			System.out.println("Authorized");
		
			//Create session
			HttpSession session = req.getSession(true);	//true, because it will create new session invalidating existing session
			session.setAttribute("authUser", authorizedUser);
			
			
			resp.sendRedirect(req.getContextPath()+"/userProfile");
			//req.getRequestDispatcher("UserList.jsp").forward(req, resp);
		}else {
			req.setAttribute("unsucessfulMsg", "Username or password incorrect");
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
	}

}
