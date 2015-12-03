package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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
	
//	org.springframework.web.servlet.DispatcherServlet
	
	
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
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		System.out.println("init servlet.DispatcherServlet");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy servlet.DispatcherServlet");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doGet servlet.DispatcherServlet");

		// front + command
		String url = request.getRequestURI(); // _/eGofmvc/DispatcherServlet.do

		url = url.substring(url.lastIndexOf("/"));

		System.out.println("url : " + url);

		HandlerMapping handlerMapping = new HandlerMapping();

		// 맵핑에 대한 로직.
		Controller controller = handlerMapping.getMapping(url);

		// 처리 로직.
		String view = controller.handleResquest(request, response);

		// 흐름 제어 ###########
		getServletContext().getRequestDispatcher(view).forward(request, response);

		/*
		 * // 기본주석 // jsp-jdbc 기반 ########### // dao 접근 UserDAO dao = new
		 * UserDAO_JDBC(); // 서비스 UserService service = new
		 * UserServiceImpl(dao); // 결과 List<UserVO> list =
		 * service.getUserList();
		 * 
		 * // request set request.setAttribute("users", list);
		 * 
		 * System.out.println("doGet servlet.DispatcherServlet 확인 : " + list);
		 * System.out.println(request.getParameterNames());
		 * 
		 * // 흐름 제어 ########### // 컨텍스트 ServletContext servletContext =
		 * getServletContext();
		 * 
		 * // 요청 디스패쳐 RequestDispatcher requestDispatcher =
		 * servletContext.getRequestDispatcher("/list.jsp");
		 * 
		 * // 포워드 [request] requestDispatcher.forward(request, response);
		 * 
		 * // ############################# // 프론트 패턴으로 집중화 시킴 + service 패턴 적용할.
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost servlet.DispatcherServlet");

		doGet(request, response);
	}

}
