package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
}
