package edu.fra.uas.user.model;

import java.util.ArrayList;

import edu.fra.uas.rating.model.Rating;

public class Doctor extends User {
	
	private ArrayList<Rating> ratings;


	public Doctor(long id, String name, String email, String password, ArrayList<Rating> ratings) {
		super(id, name, email, password, Role.DOCTOR);
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
