package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 클리이언트 요청에 대한 인터페이스 정의
 * @author student
 *
 */
public interface Controller {
	public String handleResquest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
