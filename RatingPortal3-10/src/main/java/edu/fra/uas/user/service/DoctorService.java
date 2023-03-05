package edu.fra.uas.user.service;

import java.util.List;

import edu.fra.uas.rating.model.Rating;
import edu.fra.uas.user.model.Doctor;

public interface DoctorService {

	
	
	 public List<Rating> getDoctorRatings(long doctorId);

	 public double getAverageRatingForDoctor(long doctorId);
	 
	 public List<Doctor> getAllDoctors();
	 
	 public Doctor getDoctorById(int id);
	 
	 public Doctor addDoctor(Doctor doctor);
	 
	 public Doctor updateDoctor(int id, Doctor doctor);
	 
	 public boolean deleteDoctor(int id);
	
	
	
	
	
	
	
	
}
