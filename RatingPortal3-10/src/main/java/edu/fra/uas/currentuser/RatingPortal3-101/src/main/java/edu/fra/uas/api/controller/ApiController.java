package edu.fra.uas.api.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.fra.uas.rating.dto.RatingDTO;
import edu.fra.uas.rating.model.Rating;
import edu.fra.uas.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class ApiController {

	private final RatingService ratingService;

	public ApiController(RatingService ratingService) {
		this.ratingService = ratingService;
	}

	@GetMapping("/all")
	public List<Rating> getAllRatings() {
		return ratingService.getAllRatings();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getRatingById(@PathVariable long id, Model model) {
		try {
			RatingDTO ratingDTO = ratingService.getRatingById(id);
			model.addAttribute(ratingDTO);
			return new ResponseEntity<>(ratingDTO, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			String response = "Rating ID existiert nicht.";
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/rating", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating, Model model) {

		Rating newRating = ratingService.createRating(rating);
		model.addAttribute("rating", newRating);
		return ResponseEntity.ok().body(newRating);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Rating> updateRating(@PathVariable("id") long id, @RequestBody Rating updatedRating,
			Model model) {
		Rating rating = ratingService.getRatingById1(id);

		if (rating == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		rating.setRatingValue(updatedRating.getRatingValue());
		rating.setPatient(updatedRating.getPatient());

		Rating savedRating = ratingService.getRatingById1(rating.getId());
		model.addAttribute(savedRating);

		return new ResponseEntity<>(savedRating, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRating(@PathVariable("id") long id, Model model) {
        Rating ratingOptional = ratingService.getRatingById1(id);
		
		if (ratingService.getAllRatings().contains(ratingOptional)) {
			ratingService.deleteRating(id);
			return ResponseEntity.ok().build();	
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		}
		
		

        
	}
}
