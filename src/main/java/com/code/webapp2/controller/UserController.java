package com.code.webapp2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.code.webapp2.User;
import com.code.webapp2.dao.UserRepo;

@RestController
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
	
	// Rest API implementation
	@GetMapping("/users")
	public List<User> getUserDetails() {
		return userRepo.findAll();
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getUserByUserId(@PathVariable("id") int id) {
		return userRepo.findById(id);
	}
	
	@PostMapping("/addUser")
	public User addUserDetails(@RequestBody User user) {
		userRepo.save(user);
		return user;
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		userRepo.save(user);
		return user;
	}
	
	@DeleteMapping("/user/{id}")
	public int deleteUser(@PathVariable("id") int id) {
		@SuppressWarnings("deprecation")
		User user = userRepo.getOne(id);
		System.out.println("ABC");
		userRepo.delete(user);
		return 1;
	}
}
