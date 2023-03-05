package edu.fra.uas.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.fra.uas.patient.repository.PatientRepository;
import edu.fra.uas.user.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {
	

		private final PatientRepository patientrepository;
	
	    //Constructor
	    
	    public PatientServiceImpl(PatientRepository patientrepository) {
			super();
			this.patientrepository = patientrepository;
		}

	    //Mothods
@Override	    
		public List<Patient> getAllPatients() {
	        return patientrepository.findAll();
	    }
	    
@Override	    
		public Patient getPatientById(long id) {
	        return patientrepository.findAll().stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	    }
@Override	    
	    public Patient addPatient(Patient patient) {
	        long newId = patientrepository.findAll().size() + 1;
	        patient.setId(newId);
	        patientrepository.findAll().add(patient);
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
	        return patientrepository.findAll().remove(patient);
	    }
	    
	}


