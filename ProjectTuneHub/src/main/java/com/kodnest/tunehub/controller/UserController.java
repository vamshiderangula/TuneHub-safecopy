package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.serviceimpl.SongServiceimpl;
import com.kodnest.tunehub.serviceimpl.UserServiceimpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserServiceimpl userServiceimpl;
	@Autowired
	SongServiceimpl songServiceimpl;

	@PostMapping("/register")
	public String addUsers(@ModelAttribute User user) {
		//email taken from registration form
		String email=user.getEmail();
		String role=user.getRole();
		//checking if email as enetered in reg form is present in db or not 
		boolean status=userServiceimpl.emailExists(email);
		if(status==false) {
			userServiceimpl.addUsers(user);
			System.out.println("user added");
			
		}
		else {
			System.out.println("user already exists");
		}
	    return "login";
	}

	
	@PostMapping("/validate")
	public String validate(@RequestParam("email")String email,
			@RequestParam("password")String password, HttpSession session,Model model) {
		if(userServiceimpl.validateUser(email, password) == true){
			String role = userServiceimpl.getRole(email);
			session.setAttribute("email", email);
			if(role.equalsIgnoreCase("admin")) {
				return "admin";
			}else {
				User user = userServiceimpl.getUser(email);
				boolean userstatus=user.isIspremium();
				System.out.println(user.isIspremium());
				model.addAttribute("ispremium", userstatus);
				List<Song> song =songServiceimpl.fetchAllSongs();
				model.addAttribute("song", song);
				
				return "customer";
			}
		}else {
			return "login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}


}
//@RequestParam("username") String username,
//@RequestParam("email") String email,
//@RequestParam("password") String password,
//@RequestParam("gender") String gender,
//@RequestParam("role") String role,
//@RequestParam("address") String address
