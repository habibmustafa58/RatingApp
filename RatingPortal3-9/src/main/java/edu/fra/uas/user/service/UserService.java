package edu.fra.uas.user.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fra.uas.user.model.Doctor;
import edu.fra.uas.user.model.Role;
@Service
public class UserService {

    private List<Doctor> doctors;
@Autowired
    public UserService() {
        doctors = new ArrayList<>();
        doctors.add(new Doctor(1,"Dr. John Doe", "john.doe@doc.com", "pass1", Role.DOC ));
        doctors.add(new Doctor(2,"Dr. Jane Smith", "jane.smith@doc.com", "pass2", Role.DOC ));
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



//package edu.fra.uas.user.service;
//
//import java.util.List;
//
//import org.springframework.context.annotation.Bean;
//
//import edu.fra.uas.user.model.Doctor;
//
//
//public class UserService {
//
//	public UserService() {
//	
//}
//	@Bean
//	public List<Doctor> getAllDoctors() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
