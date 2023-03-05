package edu.fra.uas.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
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

	
	private final DoctorService doctorService;
	@Autowired
	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;
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
