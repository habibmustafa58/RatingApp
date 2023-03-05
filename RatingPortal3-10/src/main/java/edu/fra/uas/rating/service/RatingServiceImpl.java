package edu.fra.uas.rating.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import edu.fra.uas.doctor.repository.DoctorRepository;
import edu.fra.uas.patient.repository.PatientRepository;
import edu.fra.uas.rating.dto.RatingDTO;
import edu.fra.uas.rating.model.Rating;
import edu.fra.uas.rating.repository.RatingRepository;
import edu.fra.uas.user.model.Doctor;
import edu.fra.uas.user.model.Patient;

@Service
public class RatingServiceImpl implements RatingService {

	    
	    private final RatingRepository ratingRepository;
	    private final PatientRepository patientRepository;
 
	    
	    
	    public RatingServiceImpl(PatientRepository patientRepository, RatingRepository ratingRepository) {
	        this.patientRepository = patientRepository;
	        this.ratingRepository = ratingRepository;
	        
	    }
   	
	    
@Override
	    public List<Rating> getAllRatings() {
	        return ratingRepository.getAllRatings();
	    }

@Override
	    public RatingDTO getRatingById(long id) {
	     Rating r1 = ratingRepository.getAllRatings().stream()
	                .filter(rating -> rating.getId().equals(id))
	                .findFirst()
	                .orElseThrow(() -> new NoSuchElementException(String.format("User mit folgender Id nicht gefunden: ", id)));
	        
	     RatingDTO ratingDTO = new RatingDTO();
	        
	       
	        BeanUtils.copyProperties(r1, ratingDTO);
	        return ratingDTO;
//	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rating not found"));
	    }
@Override
	    public Rating createRating(int ratingValue, long doctorId, long patientId) {
	        Patient patient = (Patient) patientRepository.findById(patientId);
	        
	        Rating rating = new Rating (ratingValue, patient);
	        rating.setId(ratingRepository.getAllRatings().size() + 1);
	        ratingRepository.getAllRatings().add(rating);
	        return rating;
	    }

@Override
	    public Rating updateRating(long id, RatingDTO ratingDTO) {
	        Rating r2 = ratingRepository.getAllRatings().stream()
	                .filter(rating -> rating.getId().equals(id))
	                .findFirst()
	                .orElseThrow(() -> new NoSuchElementException(String.format(">>> User=%s not found", id)));

	        r2.setRatingValue(ratingDTO.getRatingValue());

	        return r2;
	    }
@Override
	    public void deleteRating(long id) {
	        Rating r3 = ratingRepository.getAllRatings().stream()
	                .filter(rating -> rating.getId().equals(id))
	                .findFirst()
	                .orElseThrow(() -> new NoSuchElementException(String.format(">>> User=%s not found", id)));

	        ratingRepository.getAllRatings().remove(r3);
	    }
@Override
		public List<Rating> getRatings() {
				return ratingRepository.getAllRatings();
		}




	}

