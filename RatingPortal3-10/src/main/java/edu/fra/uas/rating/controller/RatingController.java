package edu.fra.uas.rating.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.fra.uas.doctor.repository.DoctorRepository;
import edu.fra.uas.patient.repository.PatientRepository;
import edu.fra.uas.rating.model.Rating;
import edu.fra.uas.rating.repository.RatingRepository;
import edu.fra.uas.user.model.Doctor;
import edu.fra.uas.user.model.Patient;
import edu.fra.uas.user.service.DoctorService;
import edu.fra.uas.user.service.UserService;

@Controller
public class RatingController {

	private final DoctorRepository doctorRepository;
	private final DoctorService doctorServie;
	private final RatingRepository ratingRepository;
	private final PatientRepository patientRepository;
	private final PatientRepository patientService;
	private final UserService userService;

	public RatingController(DoctorRepository doctorRepository, DoctorService doctorServie,
			RatingRepository ratingRepository, PatientRepository patientRepository, PatientRepository patientService,
			UserService userService) {
		super();
		this.doctorRepository = doctorRepository;
		this.doctorServie = doctorServie;
		this.ratingRepository = ratingRepository;
		this.patientRepository = patientRepository;
		this.patientService = patientService;
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
		
		Doctor doc
			
//	        } else {
//	            Doctor doctor = doctorServie.findDoctorByEmail(email1);
//	            List<Rating> ratings = doctor.getRatings();
//	            double avgRating = calculateAverageRating(ratings);
//	            model.addAttribute("avgRating", avgRating);
//	            model.addAttribute("doctor", doctor);
//	            model.addAttribute("ratings", ratings);
		return "home-doctor";
	            
	}

	@PostMapping("/rate-doctor")
	public String rateDoctor(Principal principal, @RequestParam long doctorId, @RequestParam int ratingValue) {
		String email = principal.getName();
		boolean isPatient = email.endsWith("@patient.de");

		if (isPatient) {
			Doctor doctor = doctorRepository.findById(doctorId);
			if (doctor != null) {
				Rating rating = new Rating(ratingValue);
				rating.getPatient().setEmail(email);
				doctor.addRating(rating);
				ratingRepository.addRating(rating);
				doctorRepository.save(doctor);
			}
		}

		return "redirect:/home-patient";
	}

	private double calculateAverageRating(List<Rating> ratings) {
		if (ratings.isEmpty()) {
			return 0;
		}
		double sum = 0;
		for (Rating rating : ratings) {
			sum += rating.getRatingValue();
		}
		return sum / ratings.size();
	}
}
