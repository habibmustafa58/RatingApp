package edu.fra.uas.user.service;

import java.util.List;

import edu.fra.uas.rating.model.Rating;
import edu.fra.uas.user.model.Doctor;

public interface DoctorService {

	
	
	 public List<Rating> getDoctorRatings(long doctorId);
	 
	 public List<Doctor> getAllDoctors();
	 
	 public Doctor getDoctorById(long id);
	 
	 public Doctor addDoctor(Doctor doctor);
	 
	 public Doctor updateDoctor(long id, Doctor doctor);
	 
	 public boolean deleteDoctor(long id);

	Doctor getDoctorByName(String name);

	Doctor findDoctorByEmail(String email);
	
	
	
	
	
	
	
	
}
