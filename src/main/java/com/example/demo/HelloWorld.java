package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloWorld {

	@GetMapping("/")
	public String getStatus() {
		return "HELLO WORLD!!";
	}

	@GetMapping("/page2")
	public String getSting() {
		return "HELLO Page 2";
	}
}
