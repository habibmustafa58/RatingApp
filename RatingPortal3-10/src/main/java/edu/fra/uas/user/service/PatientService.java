package edu.fra.uas.user.service;

import java.util.List;

import edu.fra.uas.user.model.Patient;

public interface PatientService {

	
	public List<Patient> getAllPatients();
	
	public Patient getPatientById(long id);
	
	public Patient addPatient(Patient patient);
	
	public Patient updatePatient(long id, Patient patient);
	
	public boolean deletePatient(long id);
	
	

}
