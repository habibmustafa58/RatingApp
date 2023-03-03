package edu.fra.uas.rating.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.fra.uas.user.model.Doctor;
import edu.fra.uas.user.service.UserService;

@Controller
public class RatingController {

    private final UserService doctorService;
	private UserService UserService;

    public RatingController(UserService doctorService) {
        this.doctorService = new UserService();
		this.UserService = doctorService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Doctor> doctors = UserService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        
        return "homepage";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(Model model) {
        return "logout";
    }

	public UserService getDoctorService() {
		return doctorService;
	}
}

