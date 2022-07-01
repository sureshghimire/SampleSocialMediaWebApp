package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class PageFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletReq = (HttpServletRequest) request;
		
		//get all incoming path
		String incomingRequest=httpServletReq.getServletPath();
		
		
		System.out.println("incomingRequest = "+incomingRequest);
		
		if(incomingRequest.contains("kill.jsp")) {
			httpServletReq.setAttribute("message", "How dare you to access this page!!!");
			httpServletReq.getRequestDispatcher("Login.jsp").forward(httpServletReq, response);
		}else {
			//go ahead and  access it
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
	}
	
	@Override
	public void destroy() {
		
	}

	
}
