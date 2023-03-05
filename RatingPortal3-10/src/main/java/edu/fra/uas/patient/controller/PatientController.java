package edu.fra.uas.patient.controller;

import java.util.List;

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

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}

//	@GetMapping("/current")
//	public Patient getCurrentUser() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String username = authentication.getName();
//		return patientService.findPatientByName(username);
//	}
//
//	@PostMapping("/current")
//	public void updateCurrentUser(@RequestBody Patient patient) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String username = authentication.getName();
//		Patient currentUser = patientService.findPatientByName(username);
//		currentUser.setPassword(patient.getPassword());
//		currentUser.setRole(patient.getRole());
//		patientService.addPatient(currentUser);
//	}

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
