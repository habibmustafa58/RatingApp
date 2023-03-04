package edu.fra.uas.user.model;

import org.springframework.stereotype.Component;

@Component
	
public class User {

	private int Id;
	private String Name;
	private String Email;
	private String Password;
	private Role role;
	
	public User(int id, String name, String email, String password, Role role) {
		super();
		Id = id;
		Name = name;
		Email = email;
		Password = password;
		this.role = role;
	}


	public User() {
		
	}
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}


	@Override
	public String toString() {
		return "User [Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", Password=" + Password + ", role=" + role
				+ "]";
	}
	
	
	
}
