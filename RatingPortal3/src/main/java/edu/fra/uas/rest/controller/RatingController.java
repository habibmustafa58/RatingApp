package edu.fra.uas.rest.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import edu.fra.uas.rating.controller.RatingNotFoundException;
import edu.fra.uas.rating.model.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private ArrayList<Rating> ratings = new ArrayList<>();

    // Get all ratings
    @GetMapping("/")
    public List<Rating> getAllRatings() {
        return ratings;
    }

    // Get a rating by ID
    @GetMapping("/{id}")
    public Rating getRatingById(@PathVariable int id) {
        return ratings.stream()
                .filter(rating -> rating.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RatingNotFoundException(id));
    }

    // Create a new rating
    @PostMapping("/")
    public Rating createRating(@RequestBody Rating rating) {
        rating.setId(rating.getId()+1);
    	
        ratings.add(rating);
        return rating;
    }

    // Update an existing rating
    @PutMapping("/{id}")
    public Rating updateRating(@RequestBody Rating newRating, @PathVariable int id) {
        for (int i = 0; i < ratings.size(); i++) {
            Rating rating = ratings.get(i);
            if (rating.getId() == id) {
                rating.setPatient(newRating.getPatient());
                rating.setDoctor(newRating.getDoctor());
                rating.setRatingValue(newRating.getRatingValue());
                return rating;
            }
        }
        throw new RatingNotFoundException(id);
    }

    // Delete a rating by ID
    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable int id) {
        if (!ratings.removeIf(rating -> rating.getId() == id)) {
            throw new RatingNotFoundException(id);
        }
    }
}
