package edu.fra.uas.rating.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fra.uas.rating.model.Rating;

@Service
public class RatingService {
	
    private List<Rating> ratings;

    
    public RatingService() {
        ratings = new ArrayList<>();
    }

    public List<Rating> getAllRatings() {
        return ratings;
    }

    public Rating getRatingById(int id) {
        for (Rating r : ratings) {
            if (r.getratingId() == id) {
                return r;
            }
        }
        return null;
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public void updateRating(Rating rating) {
        for (Rating r : ratings) {
            if (r.getratingId() == rating.getratingId()) {
                r.setDoctor(rating.getDoctor());
                r.setPatient(rating.getPatient());
                r.setratingId(rating.getratingId());
                return;
            }
        }
    }

    public void deleteRatingById(int id) {
        ratings.removeIf(r -> r.getratingId() == id);
    }
}
