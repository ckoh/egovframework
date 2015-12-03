package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller{
	
	/**
	 * 로그인 ui 제공
	 */
	@Override
	public String handleResquest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("handleResquest LoginController loginForm.jsp");
		return "/loginForm.jsp";
	}

}
