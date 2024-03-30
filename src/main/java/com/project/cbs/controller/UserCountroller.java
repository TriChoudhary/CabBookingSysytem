package com.project.cbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.cbs.serviceImpl.UserServiceImpl;
@Controller
public class UserCountroller {
	@Autowired
	UserServiceImpl userService;
	

	
	@PostMapping("/selectcar/{username}")
	public String car(@PathVariable("username")String username, @RequestParam ("pick_up_point")String pick_up_point,@RequestParam ("destination")String destination,Model model) {
		model.addAttribute(pick_up_point);
		model.addAttribute(destination);
		model.addAttribute(username);
		System.out.println(username);
		System.out.println(pick_up_point);
		System.out.println(destination);
		return "choosecar";
	}
	@GetMapping("/postlogin/status")
	public String status() {
		return "status";
	}
}
