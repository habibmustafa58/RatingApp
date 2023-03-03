package edu.fra.uas.user.model;


public class User {
	
	private int Id;
	private String Name;
	private String Email;
	private Role role;
	
	public User(int id, String name, String email, Role role) {
		super();
		Id = id;
		Name = name;
		Email = email;
		this.role = role;
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
	
	
	
}
