package edu.fra.uas.rating.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.fra.uas.doctor.repository.DoctorRepository;
import edu.fra.uas.rating.model.Rating;
import edu.fra.uas.rating.repository.RatingRepository;
import edu.fra.uas.user.model.Doctor;
import edu.fra.uas.user.model.Patient;
import edu.fra.uas.user.service.UserService;

@Controller
public class RatingController {

	private final DoctorRepository doctorRepository;
	private final RatingRepository ratingRepository;
	private final UserService userService;

	public RatingController(DoctorRepository doctorRepository,
			RatingRepository ratingRepository,
			UserService userService) {
		super();
		this.doctorRepository = doctorRepository;
		this.ratingRepository = ratingRepository;
		this.userService = userService;
	}

	@GetMapping("/home-doctor")
	public String getHomeDoctor() {
		return "home-doctor";
	}

	@GetMapping("/home")
	public String showHomePage(@RequestParam String email, Model model) {

		Doctor doc = userService.findDoctorByEmail(email);
		if (email.contains("@doc.de")) {
			List<Rating> ratings = new ArrayList<>();
			List<Patient> patients = new ArrayList<>();
			for (Rating rating : doc.getRatings()) {
				ratings.add(rating);
				patients.add(rating.getPatient());
			}
			model.addAttribute("ratings", ratings);
			model.addAttribute("avgRating", doc.getAvgRating());
			model.addAttribute("patientsRatings", patients);
			return "home-doctor";
		}

		else {
			ArrayList<Doctor> doctors = new ArrayList<>();
			for (Doctor doctor2 : doctorRepository.findAll()) {
				doctors.add(doctor2);
				model.addAttribute("doctors", doctors);
				model.addAttribute("docName", doctor2.getName());
				model.addAttribute("docEmail", doctor2.getEmail());
				model.addAttribute("docavgRating", doctor2.getAvgRating());

			}
			return "home-patient";
		}

	}

	@PostMapping("/rate-doctor")
	public String rateDoctor(@RequestParam long Id, @RequestParam int ratingValue) {
		
		Rating rating = new Rating(ratingValue);
		rating = ratingRepository.getRatingById(Id);
		
		

		return "redirect:/home";
	}

}
