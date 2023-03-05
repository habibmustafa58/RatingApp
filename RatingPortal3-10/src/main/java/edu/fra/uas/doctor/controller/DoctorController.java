package edu.fra.uas.doctor.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	    public DoctorController(DoctorService doctorService) {
	        this.doctorService = doctorService;
	    }

	    @GetMapping ("/all")
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

