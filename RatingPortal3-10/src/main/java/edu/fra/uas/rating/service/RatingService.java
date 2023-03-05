package edu.fra.uas.rating.service;

import java.util.List;

import edu.fra.uas.rating.dto.RatingDTO;
import edu.fra.uas.rating.model.Rating;

public interface RatingService {
	
	
	public List<Rating> getAllRatings();
	 
	 public RatingDTO getRatingById(long id);
	
	 public Rating createRating(int ratingValue, long doctorId, long patientId);
	 
	 public Rating updateRating(long id, RatingDTO ratingDTO);
	 
	 public void deleteRating(long id);
	
	 public List<Rating> getRatings();

	
	 
}
