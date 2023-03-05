package edu.fra.uas.rating.model;

import edu.fra.uas.user.model.Doctor;
import edu.fra.uas.user.model.Patient;

public class Rating {
    private long id;
    private int ratingValue;
    private Doctor doctor;
    private Patient patient;

    public Rating(long id, int ratingValue, Doctor doctor, Patient patient) {
        this.id = id;
        this.ratingValue = ratingValue;
        this.doctor = doctor;
        this.patient = patient;
    }
    public Rating(int ratingValue, Doctor doctor, Patient patient) {
        this.ratingValue = ratingValue;
        this.doctor = doctor;
        this.patient = patient;
    }

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(int ratingValue) {
		this.ratingValue = ratingValue;
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
