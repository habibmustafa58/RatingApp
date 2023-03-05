package edu.fra.uas.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fra.uas.user.model.Doctor;
import edu.fra.uas.user.model.Patient;
import edu.fra.uas.user.service.DoctorService;
import edu.fra.uas.user.service.PatientService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final DoctorService doctorService;

	private final PatientService patientService;

	@Autowired
	public UserController(DoctorService doctorService, PatientService patientService) {
		super();
		this.doctorService = doctorService;
		this.patientService = patientService;
	}
	
	@GetMapping ("/patients/all")
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}

	@GetMapping("/patients/{id}")
	public Patient getPatientById(@PathVariable long id) {
		return patientService.getPatientById(id);
	}

	@PutMapping("/patients/{id}")
	public Patient updatePatient(@PathVariable long id, @RequestBody Patient patient) {
		return patientService.updatePatient(id, patient);
	}

	@DeleteMapping("/patients/{id}")
	public void deletePatient(@PathVariable long id) {
		patientService.deletePatient(id);
	}
	
	
	@GetMapping("/doctors/all")
	public List<Doctor> getAllDoctors() {
		return doctorService.getAllDoctors();
	}

	@GetMapping("/doctors/{id}")
	public Doctor getDoctorById(@PathVariable long id) {
		return doctorService.getDoctorById(id);
	}

	@PutMapping("/doctors/{id}")
	public Doctor updateDoctor(@PathVariable long id, @RequestBody Doctor doctor) {
		return doctorService.updateDoctor(id, doctor);
	}

	@DeleteMapping("/doctors/{id}")
	public void deleteDoctor(@PathVariable long id) {
		doctorService.deleteDoctor(id);
	}

}
