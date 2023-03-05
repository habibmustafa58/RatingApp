package edu.fra.uas.rating.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import edu.fra.uas.doctor.repository.DoctorRepository;
import edu.fra.uas.patient.repository.PatientRepository;
import edu.fra.uas.rating.dto.RatingDTO;
import edu.fra.uas.rating.model.Rating;
import edu.fra.uas.user.model.Doctor;
import edu.fra.uas.user.model.Patient;

@Service
public class RatingServiceImpl implements RatingService {

	    private final List<Rating> ratings = new ArrayList<>();
	    
	    private final DoctorRepository doctorRepository;
	    private final PatientRepository patientRepository;
 
	    
	    
	    public RatingServiceImpl(DoctorRepository doctorRepository, PatientRepository patientRepository) {
	        this.doctorRepository = doctorRepository;
	        this.patientRepository = patientRepository;
	        
	    }
   	
	    
@Override
	    public List<Rating> getAllRatings() {
		for (Doctor doctor : doctorRepository.getDoctors()) {
			for (Rating rating :  doctor.getRatings()) {
					ratings.add(rating);
				} 
			}
	        return ratings;
	    }

@Override
	    public RatingDTO getRatingById(long id) {
	     Rating r1 = ratings.stream()
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
	        Doctor doctor = doctorRepository.findById(doctorId);
	        Patient patient = (Patient) patientRepository.findById(patientId);
	        
	        Rating rating = new Rating (ratingValue, doctor, patient);
	        rating.setId(ratings.size() + 1);
	        ratings.add(rating);
	        return rating;
	    }

@Override
	    public Rating updateRating(long id, RatingDTO ratingDTO) {
	        Rating r2 = ratings.stream()
	                .filter(rating -> rating.getId().equals(id))
	                .findFirst()
	                .orElseThrow(() -> new NoSuchElementException(String.format(">>> User=%s not found", id)));

	        r2.setRatingValue(ratingDTO.getRatingValue());

	        return r2;
	    }
@Override
	    public void deleteRating(long id) {
	        Rating r3 = ratings.stream()
	                .filter(rating -> rating.getId().equals(id))
	                .findFirst()
	                .orElseThrow(() -> new NoSuchElementException(String.format(">>> User=%s not found", id)));

	        ratings.remove(r3);
	        r3.getDoctor().getRatings().remove(r3);
	    }
@Override
		public List<Rating> getRatings() {
				return ratings;
		}




	}

