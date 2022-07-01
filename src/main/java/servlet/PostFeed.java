package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostEntry;
import model.User;
import service.Db;


@WebServlet("/postFeed")
public class PostFeed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		if(session !=null) {
			User user = (User) session.getAttribute("authUser");
						
		}
		
		Db service = new Db();
		List<PostEntry> allPost = service.getAllPosts();
		for(PostEntry entry: allPost) {
			System.out.println(entry.toString());
		}
		
		request.setAttribute("allPost", allPost);
		service.close();
		
		request.getRequestDispatcher("PostFeed.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

}
