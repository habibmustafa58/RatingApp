package edu.fra.uas.doctor.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.fra.uas.rating.model.Rating;
import edu.fra.uas.user.model.Doctor;

@Component
public class DoctorRepository {

    private List<Doctor> doctors = new ArrayList<>();

    public List<Doctor> findAll() {
        return doctors;
    }

    public Doctor findById(long id) {
        return doctors.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Doctor doctor) {
        if (findById(doctor.getId()) == null) {
            doctors.add(doctor);
        } else {
            update(doctor);
        }
    }

    public void deleteById(long id) {
        doctors.removeIf(d -> d.getId() == id);
    }

    private void update(Doctor updatedDoctor) {
        Doctor doctor = findById(updatedDoctor.getId());
        if (doctor != null) {
            doctor.setName(updatedDoctor.getName());
            doctor.setEmail(updatedDoctor.getEmail());
            
        }
    }
    
	public double getAverageRatingForDoctor(long doctorId) {
		Doctor doctor = findById(doctorId);
		List<Rating> ratings = doctor.getRatings();
		double sum = 0;
		for (Rating rating : ratings) {
			sum += rating.getRatingValue();
		}
		return sum / ratings.size();
	}
	
	public double getAverageRatingForDoctorByDoctor(Doctor doctor) {		
		List<Rating> ratings = doctor.getRatings();
		double sum = 0;
		for (Rating rating : ratings) {
			sum += rating.getRatingValue();
		}
		return sum / ratings.size();
	}


	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
    
}

