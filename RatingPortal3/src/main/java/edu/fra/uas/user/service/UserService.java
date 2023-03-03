package edu.fra.uas.user.service;


import java.util.ArrayList;
import java.util.List;

import edu.fra.uas.user.model.Doctor;
import edu.fra.uas.user.model.Role;

public class UserService {

    private List<Doctor> doctors;

    public UserService() {
        doctors = new ArrayList<>();
        doctors.add(new Doctor(1,"Dr. John Doe", "john.doe@doc.com", Role.DOC));
        doctors.add(new Doctor(2,"Dr. Jane Smith", "jane.smith@doc.com", Role.DOC));
    }

    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    public Doctor getDoctorByEmail(String email) {
        for (Doctor doctor : doctors) {
            if (doctor.getEmail().equals(email)) {
                return doctor;
            }
        }
        return null;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    public void updateDoctor(Doctor doctorToUpdate, Doctor newDoctor) {
        int index = doctors.indexOf(doctorToUpdate);
        if (index != -1) {
            doctors.set(index, newDoctor);
        }
    }

}

