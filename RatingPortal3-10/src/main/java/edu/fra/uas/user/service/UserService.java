package edu.fra.uas.user.service;

import java.util.List;

import edu.fra.uas.rating.model.Rating;
import edu.fra.uas.user.model.Doctor;
import edu.fra.uas.user.model.Patient;

public interface UserService {
	
	
	//Methods for Patient
	public List<Patient> getAllPatients();
	
	public Patient getPatientById(long id);
	
	public Patient addPatient(Patient patient);
	
	public Patient updatePatient(long id, Patient patient);
	
	public boolean deletePatient(long id);

	Patient findPatientByName(String name);

	Patient findPatientByEmail(String email);
	
	//Methods for Doctors
	
	public List<Rating> getDoctorRatings(long doctorId);

	 public double getAverageRatingForDoctor(long doctorId);
	 
	 public List<Doctor> getAllDoctors();
	 
	 public Doctor getDoctorById(long id);
	 
	 public Doctor addDoctor(Doctor doctor);
	 
	 public Doctor updateDoctor(long id, Doctor doctor);
	 
	 public boolean deleteDoctor(long id);

	Doctor getDoctorByName(String name);

	Doctor findDoctorByEmail(String email);
}
