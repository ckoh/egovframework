package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import user.service.UserService;
import user.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	//
//	user_form.jsp
//	user_list.jsp
//	user_modify.jsp
//	user_view.jsp
//	user_write.jsp
	//
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/user/user_list.do")
	public ModelAndView getUserList() {
		
		System.out.println("getUserList UserController");
		
		ModelAndView view = new ModelAndView();
		
		List<UserVO> userList = service.getUserList();
		
		view.addObject("users", userList);
		view.setViewName("user/user_list");
		
		return view;
	}
}
