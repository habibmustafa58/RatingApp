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

import edu.fra.uas.user.model.Patient;
import edu.fra.uas.user.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	
	
	private final PatientService patientService;
@Autowired
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}


	@GetMapping ("/all")
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}

	@GetMapping("/{id}")
	public Patient getPatientById(@PathVariable long id) {
		return patientService.getPatientById(id);
	}

	@PutMapping("/{id}")
	public Patient updatePatient(@PathVariable long id, @RequestBody Patient patient) {
		return patientService.updatePatient(id, patient);
	}

	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable long id) {
		patientService.deletePatient(id);
	}
}
