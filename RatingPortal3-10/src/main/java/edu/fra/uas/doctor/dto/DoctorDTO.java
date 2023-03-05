package edu.fra.uas.doctor.dto;

import java.util.List;

import edu.fra.uas.rating.model.Rating;

public class DoctorDTO {
    private String name;
    private String email;
    private List<Rating> ratings;
    
	public DoctorDTO(String name, String email, List<Rating> ratings) {
		super();
		this.name = name;
		this.email = email;
		this.ratings = ratings;
	}

	public DoctorDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
    
    
}

