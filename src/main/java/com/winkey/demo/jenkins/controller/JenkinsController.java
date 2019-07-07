package com.winkey.demo.jenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsController {

	//SayHello
	@GetMapping("/sayHi")
	public String sayHi() {
		return "Hie......?";
	}
	
}
