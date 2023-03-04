package edu.fra.uas.rest.controller;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

//import edu.fra.uas.currentuser.CurrentUserUtil;
import edu.fra.uas.rating.controller.RatingNotFoundException;
import edu.fra.uas.rating.model.Rating;
import edu.fra.uas.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RESTController {

    private static final int MAXRATINGS = 1;
	private ArrayList<Rating> ratings = new ArrayList<>();
    //Verbindung zu den Ärzten 
    
	
    // Get all ratings
    @GetMapping("/")
    public List<Rating> getAllRatings() {
        return ratings;
    }
    
//    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity<CollectionModel<Rating>> getRatings(@RequestParam Model model) {
//		String from = CurrentUserUtil.getCurrentUser(model);
//        List<Rating> ratingList = RatingService.getAllRatings();
//    }
        
        
   
    // Get a rating by ID
    @GetMapping("/{id}")
    public Rating getRatingById(@PathVariable int id) {
        return ratings.stream()
                .filter(rating -> rating.getratingId() == id)
                .findFirst()
                .orElseThrow(() -> new RatingNotFoundException(id));
    }

    // Create a new rating
    @PostMapping("/")
    public Rating createRating(@RequestBody Rating rating) {
        rating.setratingId(rating.getratingId()+1);
    	
        ratings.add(rating);
        return rating;
    }

    // Update an existing rating
    @PutMapping("/{id}")
    public Rating updateRating(@RequestBody Rating newRating, @PathVariable int id) {
        for (int i = 0; i < ratings.size(); i++) {
            Rating rating = ratings.get(i);
            if (rating.getratingId() == id) {
                rating.setPatient(newRating.getPatient());
                rating.setDoctor(newRating.getDoctor());
                rating.setratingId(newRating.getratingId());
                return rating;
            }
        }
        throw new RatingNotFoundException(id);
    }

    // Delete a rating by ID
    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable int id) {
        if (!ratings.removeIf(rating -> rating.getratingId() == id)) {
            throw new RatingNotFoundException(id);
        }
    }
}
