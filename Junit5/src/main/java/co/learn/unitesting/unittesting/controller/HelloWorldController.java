package co.learn.unitesting.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("hello-world")
	public String helloword() {
		return "hello world";
	}

}
