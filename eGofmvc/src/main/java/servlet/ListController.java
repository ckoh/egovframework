package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDAO;
import user.dao.UserDAO_JDBC;
import user.service.UserService;
import user.service.UserServiceImpl;
import user.vo.UserVO;

public class ListController implements Controller {

	@Override
	public String handleResquest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// jsp-jdbc 기반 ###########
		// dao 접근
		UserDAO dao = new UserDAO_JDBC();
		// 서비스
		UserService service = new UserServiceImpl(dao);
		// 결과
		List<UserVO> list = service.getUserList();

		// request set
		request.setAttribute("users", list);

		System.out.println("doGet servlet.DispatcherServlet 확인 : " + list);
		System.out.println(request.getParameterNames());

		return "/list.jsp";
	}
}
