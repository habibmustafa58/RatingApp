package edu.fra.uas.user.model;

import org.springframework.stereotype.Component;
import edu.fra.uas.user.model.Role;

@Component
public class Patient extends User {

	public Patient(int id, String name, String email, String password, Role role) {
		super(id, name, email, password, role);
	}

	public Patient() {
		super();
	}

	
	
	

	

	
	
	
	
}
