package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDAO;
import user.dao.UserDAO_JDBC;
import user.service.UserService;
import user.service.UserServiceImpl;
import user.vo.UserVO;

public class DispatcherServlet extends HttpServlet {
    
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("사용자 DispatcherServlet 생성");
	}
	public void destroy() {
		System.out.println("사용자 DispatcherServlet 소멸");
	}

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		   
		   String uri = request.getRequestURI();
	       String key = uri.substring(uri.lastIndexOf("/"));
		   HandlerMaping mapping = new HandlerMaping();
		   Controller controller = mapping.getMapping(key);
		
		   String view = controller.handleRequest(request, response);
		   
	       //흐름제어문장
	       getServletContext().
	       getRequestDispatcher(view).
	       forward(request,response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}

}
