package edu.fra.uas.rating.model;

import edu.fra.uas.user.model.Doctor;
import edu.fra.uas.user.model.Patient;

public class Rating {
	
	//Attributes
	private int Id;
	private int RatingValue;
	private Doctor doctor;
	private Patient patient;
	
	//Constructor
	public Rating(int id, int value) {
		super();
		Id = id;
		RatingValue = value;
	}
	
	
	
	public int getRatingValue() {
		return RatingValue;
	}
	public void setRatingValue(int value) {
		RatingValue = value;
	}
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}



	public Doctor getDoctor() {
		return doctor;
	}



	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}



	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	
	
	
	
}
