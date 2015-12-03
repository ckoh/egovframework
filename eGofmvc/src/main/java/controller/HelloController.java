package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Test Hello
 * @author student
 *
 */
@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		
		System.out.println("hello HelloController");
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("data", "~~~~~");
		
		return view;
	}
}
