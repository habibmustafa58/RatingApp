package edu.fra.uas.configuration;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fra.uas.doctor.repository.DoctorRepository;
import edu.fra.uas.patient.repository.PatientRepository;
import edu.fra.uas.user.model.Doctor;
import edu.fra.uas.user.model.Patient;
import edu.fra.uas.user.model.Role;
import jakarta.annotation.PostConstruct;
import edu.fra.uas.rating.model.*;
import edu.fra.uas.rating.repository.RatingRepository;


@Component
public class UserDB {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	RatingRepository ratingRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	
	
	@PostConstruct
	public void init() {
						
		Doctor doc1 = new Doctor();
		doc1.setId(1);
		doc1.setName("Dr. John Doe");
		doc1.setEmail("johndoe@doc.de");
		doc1.setPassword("passd1");
		doc1.setRatings(new ArrayList<Rating>());
		
	
		Doctor doc2 = new Doctor();
		doc2.setId(2);
		doc2.setName("Dr. Jane Smith");
		doc2.setEmail("janesmith@doc.de");
		doc2.setPassword("passd2");
		doc2.setRatings(new ArrayList<Rating>());
				
		
		Doctor doc3 = new Doctor();
		doc3.setId(3);
		doc3.setName("TestDoc");
		doc3.setEmail("testdoc@doc.de");
		doc3.setRatings(new ArrayList<Rating>());
		doc3.setRole(Role.DOCTOR);
		
						
		doctorRepository.save(doc1);
		doctorRepository.save(doc2);
		
		
		Patient patient1 = new Patient(1, "Eyüp Tolgahan Yildirim", "tolgahanyildirim57@gmail.com", "passp1");
		Patient patient2 = new Patient(2, "Habib Mustafa Koca", "habibmustafakoca@gmail.com", "passp2");
		Patient patient3 = new Patient(3, "Divya Kharbanda", "divyakharbanda@example.com", "passp3");
		Patient patient4 = new Patient(4, "Akash Mehra", "akashmehra@example.com", "passp4");
		Patient patient5 = new Patient(5, "Felix Koschitzky", "felixkoschitzky@example.com", "passp5");
		
		Patient patient6 = new Patient(6, "TestPatient", "testpatient@example.com", "passp6");
	
		patientRepository.save(patient1);
		patientRepository.save(patient2);
		patientRepository.save(patient3);
		patientRepository.save(patient4);
		patientRepository.save(patient5);
		
		
		Rating rating = new Rating(1, 3, patient6);
		
		doc3.getRatings().add(rating);
		
		double avgFromDoc1 = doc1.getAverageFromRatings();
		double avgFromDoc2 = doc2.getAverageFromRatings();
		double avgFromDoc3 = doc3.getAverageFromRatings();
		
		doc1.setAvgRating(avgFromDoc1);
		doc2.setAvgRating(avgFromDoc2);
		doc3.setAvgRating(avgFromDoc3);
		
		doctorRepository.save(doc3);
		ratingRepository.addRating(rating);
		patientRepository.save(patient6);
		
	}
	
	
	
	
	
	
	
}
