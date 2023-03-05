package edu.fra.uas.user.model;

import java.util.ArrayList;
import java.util.List;

import edu.fra.uas.rating.model.Rating;

public class Doctor extends User {
	
	private ArrayList<Rating> ratings;

	public Doctor(long id, String name, String email, ArrayList<Rating> ratings) {
		super(id, name, email, Role.DOCTOR);
		this.ratings = ratings;
	}

	
	public Doctor() {
		super();
	}


	public ArrayList<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}

	
}
