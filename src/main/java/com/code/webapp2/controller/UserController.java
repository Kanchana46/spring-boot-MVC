package com.code.webapp2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.code.webapp2.User;
import com.code.webapp2.dao.UserRepo;

@Controller
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@RequestMapping("/home")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user) {
		userRepo.save(user);
		return "home.jsp";
	}
	
	@RequestMapping("/getUser")
	public ModelAndView getUserById(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("user.jsp");
		Optional<User> user = userRepo.findById(id);
		mv.addObject("user", user);
		System.out.println(mv);
		return mv;
	}
	
	@RequestMapping("/getUserByAge")
	public ModelAndView getUserByAge(@RequestParam int age) {
		ModelAndView mv = new ModelAndView("user.jsp");
		List<User> user = userRepo.findByAge(age);
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping("/getSortedUsers")
	public ModelAndView getSortedUsers() {
		ModelAndView mv = new ModelAndView("user.jsp");
		List<User> user = userRepo.findByNameSorted();
		mv.addObject("user", user);
		return mv;
	}
}
