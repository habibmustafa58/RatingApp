package edu.fra.uas.rating.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.fra.uas.rating.model.Rating;

@Service
public class RatingRepository {
	
	    
	    private List<Rating> ratings = new ArrayList<>();
	    
	    public List<Rating> getAllRatings() {
	        return ratings;
	    }
	    
	    public Rating getRatingById(long id) {
	        for (Rating rating : ratings) {
	            if (rating.getId() == id) {
	                return rating;
	            }
	        }
	        return null;
	    }
	    
	    public void addRating(Rating rating) {
	        ratings.add(rating);
	    }
	    
	    public void updateRating(Rating rating) {
	        int index = -1;
	        for (int i = 0; i < ratings.size(); i++) {
	            if (ratings.get(i).getId() == rating.getId()) {
	                index = i;
	                break;
	            }
	        }
	        if (index >= 0) {
	            ratings.set(index, rating);
	        }
	    }
	    
	    public void deleteRating(long id) {
	        int index = 0;
	        for (int i = 0; i < ratings.size(); i++) {
	            if (ratings.get(i).getId() == id) {
	                index = i;
	                break;
	            }
	        }
	        if (index >= 0) {
	            ratings.remove(index);
	        }
	    }
	    
	    
}


