package edu.fra.uas.user.model;

public class Patient extends User {
    public Patient(long id, String name, String email) {
        super(id, name, email, Role.PATIENT);
    }


}
