package edu.fra.uas.api.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping ("/all")
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRatingById(@PathVariable long id) {
    	try {
    	RatingDTO ratingDTO = ratingService.getRatingById(id);
        return new ResponseEntity<>(ratingDTO, HttpStatus.OK);
    	} catch (NoSuchElementException e) {
			String response = "Rating ID existiert nicht.";
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
    }

//    @PostMapping
//    public Rating createRating(@RequestBody RatingDTO ratingDTO, Model model, String ratingTo ) {
//       
//   	
//    	return ratingService.createRating(ratingDTO);
//    }

    @PutMapping("/{id}")
    public Rating updateRating(@PathVariable Long id, @RequestBody RatingDTO ratingDto) {
        return ratingService.updateRating(id, ratingDto);
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
    }
}

