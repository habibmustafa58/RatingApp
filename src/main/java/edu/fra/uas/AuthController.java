package edu.fra.uas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
	@RequestMapping("/login-auth")
	public String get() {
		
		return "login-auth";
	}
	
	@RequestMapping("/fehler-anzeige")
	public String getFehler() {
		
		return "fehler-anzeige";
	}
	
	@RequestMapping("/ratingapp")
	public String geRatingApp() {
		
		return "ratingapp";
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/login-auth";
	}
}
