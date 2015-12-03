package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDAO;
import user.dao.UserDAO_JDBC;
import user.service.UserService;
import user.service.UserServiceImpl;
import user.vo.UserVO;

/**
 * 웹 서브릿 위저드로 생성 Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	/*
	 * private static final long serialVersionUID = 1L;
	 */

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	/*
	 * public DispatcherServlet() { super(); // TODO Auto-generated constructor
	 * stub }
	 */

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	/*public void init(ServletConfig config) throws ServletException {
		System.out.println("init servlet.DispatcherServlet");
	}*/

	/**
	 * @see Servlet#destroy()
	 */
	/*
	public void destroy() {
		System.out.println("destroy servlet.DispatcherServlet");
	}*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet servlet.DispatcherServlet");
		
		// jsp-jdbc 기반 ###########
		// dao 접근
		UserDAO dao = new UserDAO_JDBC();
		// 서비스
		UserService service = new UserServiceImpl(dao);
		// 결과
		List<UserVO> list = service.getUserList();
		// request
		request.setAttribute("users", list);
		
		System.out.println("doGet servlet.DispatcherServlet 확인 : " +  list);
		
		// 흐름 제어 ###########
		// 컨텍스트
		ServletContext servletContext = getServletContext();
		
		// 요청 디스패쳐
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/list.jsp");
		
		// 포워드
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost servlet.DispatcherServlet");

		doGet(request, response);
	}

}
