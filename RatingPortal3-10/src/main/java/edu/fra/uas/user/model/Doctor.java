package edu.fra.uas.user.model;

import java.util.ArrayList;

import edu.fra.uas.rating.model.Rating;

public class Doctor extends User {

	private ArrayList<Rating> ratings;
	private double avgRating;
	
	
	public Doctor(long id, String name, String email, String password, ArrayList<Rating> ratings, double avgRating) {
		super(id, name, email, password, Role.DOCTOR);
		this.ratings = ratings;
		this.avgRating = avgRating;
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

	public double getSumFromRatings() {

		double sumrating = 0;
		for (Rating rating : ratings) {
			sumrating += rating.getRatingValue();

		}
		return sumrating;
	}

	public double getAverageFromRatings() {

		return getSumFromRatings() / ratings.size();

	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	
	public void addRating(Rating r) {
		ratings.add(r);
	}

	@Override
	public String toString() {
		return "Doctor [ratings=" + ratings + ", avgRating=" + avgRating + "]";
	}
	

}
