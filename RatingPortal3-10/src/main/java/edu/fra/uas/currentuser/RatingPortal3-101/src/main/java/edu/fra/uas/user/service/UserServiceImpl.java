package edu.fra.uas.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import edu.fra.uas.doctor.repository.DoctorRepository;
import edu.fra.uas.patient.repository.PatientRepository;
import edu.fra.uas.rating.model.Rating;
import edu.fra.uas.user.model.Doctor;
import edu.fra.uas.user.model.Patient;

@Service
public class UserServiceImpl implements UserService {

	private final PatientRepository patientRepository;
	private final DoctorRepository doctorRepository;

	public UserServiceImpl(PatientRepository patientRepository, DoctorRepository doctorRepository) {
		super();
		this.patientRepository = patientRepository;
		this.doctorRepository = doctorRepository;
	}

	// Methods for Patient
	@Override
	public Patient findPatientByName(String name) {
		for (Patient patient : patientRepository.findAll()) {
			if (patient.getName().equals(name)) {
				return patient;
			}
		}
		return null; // if Patient with name not found
	}

	@Override
	public Patient findPatientByEmail(String email) {

		return patientRepository.findAll().stream().filter(p -> p.getEmail().equals(email)).findFirst()
				.orElseThrow(() -> new NoSuchElementException("Patient with email " + email + " not found"));

	}

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(long id) {
		return patientRepository.findAll().stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}

	@Override
	public Patient addPatient(Patient patient) {
		long newId = patientRepository.findAll().size() + 1;
		patient.setId(newId);
		patientRepository.findAll().add(patient);
		return patient;
	}

	@Override
	public Patient updatePatient(long id, Patient patient) {
		Patient existingPatient = getPatientById(id);
		if (existingPatient == null) {
			return null;
		}
		existingPatient.setName(patient.getName());
		existingPatient.setEmail(patient.getEmail());
		return existingPatient;
	}

	@Override
	public boolean deletePatient(long id) {
		Patient patient = getPatientById(id);
		if (patient == null) {
			return false;
		}
		return patientRepository.findAll().remove(patient);
	}

	// Methods for Doctors
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
