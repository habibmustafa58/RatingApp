package edu.fra.uas.patient.repository;

import org.springframework.stereotype.Repository;

import edu.fra.uas.user.model.Patient;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

@Repository
public class PatientRepository {
	
    private List<Patient> patients = new ArrayList<>();
    private long nextId = 1;

    public List<Patient> findAll() {
        return patients;
    }

    public Patient findById(long id) {
    	return patients.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
//        return patients.stream().filter(p -> p.getId() == id).findFirst();
    }

    public void save(Patient patient) {
        if (patient.getId() == 0) {
            patient.setId(nextId++);
        }
        patients.add(patient);
    }

    public void delete(Patient patient) {
        patients.remove(patient);
    }
}

