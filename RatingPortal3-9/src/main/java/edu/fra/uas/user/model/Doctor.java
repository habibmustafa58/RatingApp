package edu.fra.uas.user.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;

import edu.fra.uas.rating.model.Rating;

public class Doctor extends edu.fra.uas.user.model.User {
	
	private ArrayList<Rating> ratings = new ArrayList<>();
	
	//Constructors
	public Doctor(int id, String name, String email, String password, Role role) {
		super(id, name, email, password, role);
	}
//	public Doctor(int id, String name, String email, Role role) {
//		super();
//	}
	public Doctor() {
		
	}
	
	//Getter/Setter	
	public ArrayList<Rating> getRatings() {
		return ratings;
	}
	
	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}
	


	
	
}
