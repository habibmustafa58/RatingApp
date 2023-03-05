package edu.fra.uas.rating.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fra.uas.patient.repository.PatientRepository;
import edu.fra.uas.rating.dto.RatingDTO;
import edu.fra.uas.rating.model.Rating;
import edu.fra.uas.rating.repository.RatingRepository;
import edu.fra.uas.user.model.Patient;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private final RatingRepository ratingRepository;


	public RatingServiceImpl(RatingRepository ratingRepository) {
		this.ratingRepository = ratingRepository;

	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.getAllRatings();
	}

	@Override
	public RatingDTO getRatingById(long id) {
		Rating r1 = ratingRepository.getAllRatings().stream().filter(rating -> rating.getId().equals(id)).findFirst()
				.orElseThrow(
						() -> new NoSuchElementException(String.format("User mit folgender Id nicht gefunden: ", id)));

		RatingDTO ratingDTO = new RatingDTO();
		BeanUtils.copyProperties(r1, ratingDTO);
		ratingDTO.setPatientId(r1.getPatient().getId());

		return ratingDTO;
//	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rating not found"));
	}

	@Override
	public Rating getRatingById1(long id) {
		Rating r1 = ratingRepository.getAllRatings().stream().filter(rating -> rating.getId().equals(id)).findFirst()
				.orElseThrow(
						() -> new NoSuchElementException(String.format("User mit folgender Id nicht gefunden: ", id)));

		return r1;
//            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rating not found"));
	}

	@Override
	public Rating createRating(Rating rating) {

		Rating r1 = new Rating(rating.getId(), rating.getRatingValue(), rating.getPatient());
		r1.setId(ratingRepository.getAllRatings().size() + 1);
		ratingRepository.getAllRatings().add(r1);
		return r1;
	}

	@Override
	public Rating updateRating(long id, RatingDTO ratingDTO) {
		Rating r2 = ratingRepository.getAllRatings().stream().filter(rating -> rating.getId().equals(id)).findFirst()
				.orElseThrow(
						() -> new NoSuchElementException(String.format("Rating with following id not found:", id)));

		r2.setRatingValue(ratingDTO.getRatingValue());

		return r2;
	}

	@Override
	public void deleteRating(long id) {
		Rating r3 = ratingRepository.getAllRatings().stream().filter(rating -> rating.getId().equals(id)).findFirst()
				.orElseThrow(
						() -> new NoSuchElementException(String.format("Rating with following id not found:", id)));

		ratingRepository.getAllRatings().remove(r3);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRepository.getAllRatings();
	}

	@Override
	public void addRating(Rating rating) {
		ratingRepository.addRating(rating);
	}

	@Override
	public boolean isPresent(Rating rating) {
		if (ratingRepository.getAllRatings().contains(rating)) {
			return true;
		} else {
			return false;
		}
	}
}
