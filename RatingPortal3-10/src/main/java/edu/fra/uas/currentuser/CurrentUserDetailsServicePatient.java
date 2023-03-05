//package edu.fra.uas.currentuser;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import edu.fra.uas.user.model.User;
//import edu.fra.uas.user.service.PatientService;
//
//@Service
//public class CurrentUserDetailsServicePatient implements UserDetailsService {
//
//    
//    private PatientService patientService;
//  
//
//    @Autowired
//    public CurrentUserDetailsServicePatient(PatientService patientService) {
//        this.patientService= patientService;
//
//    }
//
//    @Override
//    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
//     User user = patientService.findPatientByEmail(email);
//        return new CurrentUser(user);
//    }
//    
//   
//    
//
//	
//}
