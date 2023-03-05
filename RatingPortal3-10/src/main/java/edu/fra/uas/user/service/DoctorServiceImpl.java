package edu.fra.uas.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fra.uas.doctor.repository.DoctorRepository;
import edu.fra.uas.rating.model.Rating;
import edu.fra.uas.user.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private final DoctorRepository doctorRepository;

	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	@Override
	public Doctor getDoctorByName(String name) {
		for (Doctor doctor : doctorRepository.findAll()) {
			if (doctor.getName().equals(name)) {
				return doctor;
			}
		}
		return null;
	}

	@Override
	public Doctor findDoctorByEmail(String email) {
		for (Doctor doctor : doctorRepository.findAll()) {
			if (doctor.getEmail().equals(email)) {
				return doctor;
			}
		}
		return null;
	}

	@Override
	public List<Rating> getDoctorRatings(long doctorId) {
		Doctor doctor = doctorRepository.findById(doctorId);
		List<Rating> doctorRatings = new ArrayList<>(doctor.getRatings());
		return doctorRatings;
	}

	@Override
	public double getAverageRatingForDoctor(long doctorId) {
		Doctor doctor = doctorRepository.findById(doctorId);
		List<Rating> ratings = doctor.getRatings();
		double sum = 0;
		for (Rating rating : ratings) {
			sum += rating.getRatingValue();
		}
		return sum / ratings.size();
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorById(long id) {
		return doctorRepository.findAll().stream().filter(d -> d.getId() == id).findFirst().orElse(null);
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		long newId = doctorRepository.findAll().size() + 1;
		doctor.setId(newId);
		doctorRepository.findAll().add(doctor);
		return doctor;
	}

	@Override
	public Doctor updateDoctor(long id, Doctor doctor) {
		Doctor existingDoctor = getDoctorById(id);
		if (existingDoctor == null) {
			return null;
		}
		existingDoctor.setName(doctor.getName());
		existingDoctor.setEmail(doctor.getEmail());

		return existingDoctor;
	}

	@Override
	public boolean deleteDoctor(long id) {
		Doctor doctor = getDoctorById(id);
		if (doctor == null) {
			return false;
		}
		return doctorRepository.findAll().remove(doctor);
	}

}
