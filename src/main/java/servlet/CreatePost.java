package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostEntry;
import model.User;
import service.Db;


@WebServlet("/createPost")
public class CreatePost extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String post = req.getParameter("post");
		
		HttpSession session = req.getSession(false);
		if(session !=null) {
			User user = (User) session.getAttribute("authUser");
			
			if(user !=null) {
				PostEntry entry = new PostEntry(post, user);
				System.out.println(entry.toString());
				
				Db service = new Db();
				service.createPost(entry);
				service.close();
			}
			resp.sendRedirect("postFeed");
		}
		
	}
}
