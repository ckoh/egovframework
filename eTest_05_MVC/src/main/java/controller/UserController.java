package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import user.service.UserService;
import user.vo.UserVO;
import validate.UserValidator;

@Controller
public class UserController {
  
	@Autowired
	UserService service;
	
	@RequestMapping("/user/list.do")
	public ModelAndView getUserList() {
		ModelAndView mav = new ModelAndView();
		List<UserVO> list = service.getUserList();
		mav.addObject("users", list);
		mav.setViewName("user/user_list");
		return mav;
	}
	
	@RequestMapping(value="/user/add.do",method=RequestMethod.GET)
	public String addUserForm() {
		System.out.println("addUserForm");
		return "user/user_write";
	}
	
	@RequestMapping(value="/user/add.do",method=RequestMethod.POST)
	public ModelAndView addUserProc(@ModelAttribute("user") UserVO user,
			                        BindingResult errors) {
		ModelAndView mav = new ModelAndView();

		//System.out.println(user);
		new UserValidator().validate(user, errors);
		if(errors.hasErrors()){
		   mav.setViewName("user/user_write");	
		   return mav;
		}
		service.addUser(user);
		mav.setViewName("redirect:/user/list.do");
		return mav;
	}
	@RequestMapping("/user/view.do")
	public ModelAndView getUser(@RequestParam("userid") String id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user",service.getUser(id) );
		mav.setViewName("user/user_view");
		return mav;
	}
	@RequestMapping("/user/modify.do")
	public ModelAndView modify(@RequestParam("userid") String id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user",service.getUser(id) );
		mav.setViewName("user/user_modify");
		return mav;
	}
	@RequestMapping("/user/update.do")
	public ModelAndView updateProc(@ModelAttribute("user") UserVO user) {
		service.updateUser(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/user_view");
		return mav;
	}
	@RequestMapping("/user/remove.do")
	public ModelAndView removeUser(@RequestParam("userid") String id) {
		ModelAndView mav = new ModelAndView();
		service.removeUser(id);
		mav.setViewName("redirect:/user/list.do");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception exception) {
		return "error";
	}
}






