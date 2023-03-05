package edu.fra.uas.rating.dto;

public class RatingDTO {
	    private int ratingValue;
	    private long patientId;
	    
		public RatingDTO(int ratingValue, long patientId) {
			super();
			this.ratingValue = ratingValue;
			this.patientId = patientId;
		}
		
		public RatingDTO() {
			super();
		}

		public int getRatingValue() {
			return ratingValue;
		}

		public void setRatingValue(int ratingValue) {
			this.ratingValue = ratingValue;
		}


		public long getPatientId() {
			return patientId;
		}

		public void setPatientId(long patientId) {
			this.patientId = patientId;
		}

	    
	}

