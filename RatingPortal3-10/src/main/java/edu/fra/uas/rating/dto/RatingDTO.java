package edu.fra.uas.rating.dto;

public class RatingDTO {
    private int ratingValue;
    private long doctorId;
    private long patientId;
    
	public RatingDTO(int ratingValue, long doctorId, long patientId) {
		super();
		this.ratingValue = ratingValue;
		this.doctorId = doctorId;
		this.patientId = patientId;
	}
	
	public RatingDTO() {
		super();
	}

	public int getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(int ratingValue) {
		this.ratingValue = ratingValue;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

    
}
