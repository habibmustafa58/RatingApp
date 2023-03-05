package edu.fra.uas.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fra.uas.user.model.Doctor;
import edu.fra.uas.user.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private final DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	@Autowired
	private DoctorService userService;

	@GetMapping("/current")
	public Doctor getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return userService.getDoctorByName(username);
	}

	@PostMapping("/current")
	public void updateCurrentUser(@RequestBody Doctor doctor) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Doctor currentUser = doctorService.getDoctorByName(username);
		currentUser.setPassword(doctor.getPassword());
		currentUser.setRole(doctor.getRole());
		doctorService.addDoctor(currentUser);
	}

	@GetMapping("/all")
	public List<Doctor> getAllDoctors() {
		return doctorService.getAllDoctors();
	}

	@GetMapping("/{id}")
	public Doctor getDoctorById(@PathVariable long id) {
		return doctorService.getDoctorById(id);
	}

	@PutMapping("/{id}")
	public Doctor updateDoctor(@PathVariable long id, @RequestBody Doctor doctor) {
		return doctorService.updateDoctor(id, doctor);
	}

	@DeleteMapping("/{id}")
	public void deleteDoctor(@PathVariable long id) {
		doctorService.deleteDoctor(id);
	}
}
