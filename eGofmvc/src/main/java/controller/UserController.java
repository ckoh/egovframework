package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import user.service.UserService;
import user.vo.UserVO;
import validate.UserValidater;

@Controller
public class UserController {

	@Autowired
	UserService service;

	/*
	 * @RequestMapping(value="/user/list.do,") public String list() {
	 * 
	 * return "user/user_list"; }
	 */

	/**
	 * 목록보기
	 * @return
	 */
	@RequestMapping(value = "/user/list.do")
	public ModelAndView getUserList() {

		System.out.println("getUserList UserController");

		ModelAndView view = new ModelAndView();

		List<UserVO> userList = service.getUserList();

		view.addObject("users", userList);
		view.setViewName("user/user_list");

		return view;
	}

	/**
	 *  등록 페이지
	 * @return
	 */
	@RequestMapping(value = "/user/add.do", method = RequestMethod.GET)
	public String userWirte() {

		System.out.println("userWirte UserController");
		return "user/user_write";
	}
	
	
	/**
	 * 수정페이지
	 * @return
	 */
	@RequestMapping(value="user/modify.do")
	public ModelAndView updateUserView(UserVO params) {
		
		System.out.println("updateUserView UserController : " + params);
		
		ModelAndView view = new ModelAndView();
		
		UserVO user = service.getUser(params.getUserid());
		
		view.addObject("user", user);
		view.setViewName("user/user_modify");
		
		return view;
	}
	
	/**
	 * 수정하기
	 * @return
	 */
	
	@RequestMapping(value="user/update.do")
	// public ModelAndView updateUser(UserVO params) {
	public ModelAndView updateUser(@ModelAttribute(value="user") UserVO params) {
		
		System.out.println("updateUser UserController : " + params);
		
		ModelAndView view = new ModelAndView();
		
		/*
		int row = service.updateUser(params);
		UserVO user = service.getUser(params.getUserid());
		view.addObject("user", user);*/
		
		int row = service.updateUser(params);
		// UserVO user = service.getUser(params.getUserid());
		view.addObject("user", params);
		
		view.setViewName("/user/user_view");
		
		return view;
	}
	

	/**
	 * 삽입하기
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user/add.do", method = RequestMethod.POST)
	// public ModelAndView userAdd(HttpServletRequest params) {
	public ModelAndView userAdd(@ModelAttribute("user") UserVO params, BindingResult errors) {

		System.out.println("userAdd UserController : " + params);
		ModelAndView view = new ModelAndView();
		
		/**
		 * validate 체크 후 BindingResult errors 에서 관리.
		 */
		// 검증
		new UserValidater().validate(params, errors);
		
		if(errors.hasErrors()){
			view.setViewName("user/user_write");
			return view;
		}

		/*
		 * UserVO user = new UserVO(); user.setAddress(
		 * params.getParameter("address") );
		 * user.setEmail(params.getParameter("email") );
		 * user.setPhone(params.getParameter("phone") );
		 * user.setUserid(params.getParameter("userid") );
		 * user.setUsername(params.getParameter("username") );
		 * user.setUserpwd(params.getParameter("userpwd") );
		 */

		int addUser = service.addUser(params);
		UserVO user = service.getUser(params.getUserid());

		view.addObject("users", user);

		// view.setViewName("user/user_write");
		view.setViewName("redirect:/user/list.do");
		return view;
	}
	
	/**
	 * 보여주기
	 * @param params
	 * @return
	 */
	@RequestMapping(value="/user/view")
	public ModelAndView getUser(UserVO params) {

		System.out.println("getUser UserController : " + params);

		UserVO user = service.getUser(params.getUserid());
		
		ModelAndView view = new ModelAndView();
		view.addObject("user", user);
		view.setViewName("user/user_view");

		return view;

	}
	
	/**
	 * 삭제
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/user/remove.do")
	public ModelAndView removeUser(UserVO params) throws Exception {
		
		System.out.println("removeUser UserController : " + params);
		
		// exception 테스트
		if(true){
			throw new Exception("Test exception removeUser UserController");
		}
		
		ModelAndView view = new ModelAndView();
		
		int removeUser = service.removeUser(params.getUserid());
		
		view.setViewName("redirect:/user/list.do");
		
		return view;
	}
	
	
	/**
	 * 에러 캐치
	 * 
	 * 예외 처리 페이지
	 * @return
	 */
	@ExceptionHandler(value=Exception.class)
	public String exception() {
		
		/*
			<error-page>
		  	<error-code>404</error-code>
		  	<location>/error_404.jsp</location><!-- 스프링 관리 아님. -->
		  </error-page>*/
		
		System.out.println("exception UserController : "/* + params*/);
		return "error";
		
	}
}
