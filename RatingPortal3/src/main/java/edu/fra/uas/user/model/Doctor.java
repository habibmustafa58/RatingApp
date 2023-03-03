package edu.fra.uas.user.model;

import java.util.ArrayList;


import edu.fra.uas.rating.model.Rating;

public class Doctor extends User {
	
	private ArrayList<Rating> ratings = new ArrayList<>();
	
	

	public Doctor(int id, String name, String email, Role role, ArrayList<Rating> ratings) {
		super(id, name, email, role);
		this.ratings = ratings;
	}
	public Doctor(int id, String name, String email, Role role) {
		super(id, name, email, role);

	}
	
	
	
	public ArrayList<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}


	
	
}
