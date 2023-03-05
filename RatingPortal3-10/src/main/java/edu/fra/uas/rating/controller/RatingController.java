package edu.fra.uas.rating.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class RatingController {
	
	
	
	@RequestMapping("/login")
	public String get() {
		
		return "login";
	}
	
}
