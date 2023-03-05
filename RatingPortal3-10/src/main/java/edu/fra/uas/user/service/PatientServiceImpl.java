package edu.fra.uas.user.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fra.uas.patient.repository.PatientRepository;
import edu.fra.uas.user.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private final PatientRepository patientRepository;

	// Constructor

	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	// Mothods
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

}
