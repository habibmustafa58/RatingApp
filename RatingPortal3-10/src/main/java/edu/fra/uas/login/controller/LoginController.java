package edu.fra.uas.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.fra.uas.currentuser.CurrentUser;
import edu.fra.uas.user.model.Role;
import edu.fra.uas.user.model.User;
import edu.fra.uas.user.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private CurrentUser currentUser;

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model model) {
		User user = new User();

		String docmail = "doc.de";

		if (email.contains(docmail)) {
			user = userService.findDoctorByEmail(email);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(Role.DOCTOR);
			model.addAttribute("currentUser", user);
		} else {
			user = userService.findPatientByEmail(email);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(Role.PATIENT);
			model.addAttribute("currentUser", user);

		}

		if (user.getRole() == Role.DOCTOR) {
			user = userService.findDoctorByEmail(email);
			model.addAttribute("CurrentUser", user.getEmail());
			
			if (user.getPassword().equals(password)) {
				currentUser.setUsername(email);
				return "redirect:/home?email=" + user.getEmail();
			} else {
				model.addAttribute("error", "invalid password");
				return "login";
			}

		} else if (user.getRole() == Role.PATIENT) {
			user = userService.findPatientByEmail(email);
			model.addAttribute("currentUser", user.getEmail());
			if (user.getPassword().equals(password)) {
				currentUser.setUsername(email);
				return "redirect:/home";
			} else {
				model.addAttribute("error", "invalid password");

				return "login";
			}

		} else if (!(user.getRole() == Role.DOCTOR) && !(user.getRole() == Role.PATIENT)) {
			model.addAttribute("error", "Username not found");

		}

		return "login";

	}
	
//	@GetMapping("/homepage")
//	public String getHomepage() {
//		return "homepage";
//	}
//	@GetMapping("/home-patient")
//	public String getHomePatient() {
//		return "home-patient";
//	}
//	@GetMapping("/home-doctor")
//	public String getHomeDoctor() {
//		return "home-doctor";
//	}
	
	

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws ServletException {
		request.logout();
		return "logout";
	}

}
