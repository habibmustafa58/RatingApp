package edu.fra.uas.user.model;

public class Patient extends User {
 
	public Patient(long id, String name, String email, String password) {
		super(id, name, email, password, Role.PATIENT);
	}
//	public Patient() {
//		super();
//	}

	@Override
	public String toString() {
		return "Patient []";
	}
    
	
	
	
}
