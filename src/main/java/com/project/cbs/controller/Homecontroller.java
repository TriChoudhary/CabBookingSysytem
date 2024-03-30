package com.project.cbs.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.cbs.entity.User;
import com.project.cbs.repository.UserRepository;
import com.project.cbs.serviceImpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;


@Controller
public class Homecontroller {
	
	@Autowired
	private UserRepository repo;
	@Autowired
	private UserServiceImpl userService;
	
// Maping for index page
	@GetMapping("/")
	public String home(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "index";
	
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("Log in");
		return "login";
	}

	@PostMapping("/postlogin")
	public String postLogin(@RequestParam ("email")String email,@RequestParam("password") String password ,Model  model) {
		
		if (userService.login(email, password).equals("user")) {
			
			model.addAttribute("username",userService.getUsername(email));
			model.addAttribute("cars", userService.getAllCars());
			System.out.println(model.getAttribute("cars"));
			return "userhome";
		}
		else if (userService.login(email, password).equals("admin")) {
			return "adminhome";
		}
		else {
			model.addAttribute("error","Invalid username and password");
			return"login";
		}
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "register";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute("user") User u,Model model) {
		boolean doesExist=userService.checkEmail(u.getEmail());
		System.out.println(u);
		if(doesExist) {
			System.out.println("Email id has been already exists");
			model.addAttribute("msg","Email id has been already exists");
		}
		else {
			repo.save(u);
			System.out.println("User Register Sucessfully...");
			model.addAttribute("msgs", "User Register Sucessfully... Please Log in.");
		}
		return "register";
	}

}
