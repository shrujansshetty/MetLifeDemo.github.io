package com.jsf.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsf.model.UserDtls;
import com.jsf.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserRepository userRepo;
	
	@ModelAttribute
	private void userDetails(Model m,Principal p) {
		String email=p.getName();
		UserDtls user=userRepo.findByEmail(email);
		m.addAttribute("user",user);
		//System.out.println("User Details: " + user.getFullName() + ", " + user.getEmail() + ", " + user.getAddress() + ", " + user.getQualification());
	}
	
	@GetMapping("/")
	public String home(){
		return "admin/home";
	}
	
}
