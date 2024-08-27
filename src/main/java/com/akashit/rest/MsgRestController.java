package com.akashit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {
	
	@GetMapping("/contact")
	public String contactNum() {
		return "+91 8127 627 447";
	}

	@GetMapping("/greet")
	public String greeMsg() {
		return "Good Morning";
	}

	@GetMapping("/welcome")
	public String welcomeMsg() {
		return "Welcome to Akash - IT";
	}
}
