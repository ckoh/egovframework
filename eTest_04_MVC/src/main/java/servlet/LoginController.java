package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		
		return "/loginForm.jsp";
	}

}
