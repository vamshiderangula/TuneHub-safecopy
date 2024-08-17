package com.kodnest.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@GetMapping("addsongs")
	public String addsongs() {
		return "newsong";
	}
	@GetMapping("/privacypolicys")
	public String privacypolicys() {
		return "privacypolicy";
	}
	@GetMapping("/term")
	public String term() {
		return "terms";
	}
	@GetMapping("/userlogout")
	public String userlogout() {
		return "login";
	}
	@GetMapping("/customer")
	public String customer() {
		return "customer";
	}

}
