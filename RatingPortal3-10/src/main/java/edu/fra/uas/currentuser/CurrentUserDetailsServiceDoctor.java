//package edu.fra.uas.currentuser;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import edu.fra.uas.user.model.User;
//import edu.fra.uas.user.service.DoctorService;
//@Service
//public class CurrentUserDetailsServiceDoctor implements UserDetailsService {
//
//	  private DoctorService doctorService;
//	  
//	  
//	public CurrentUserDetailsServiceDoctor(DoctorService doctorService) {
//		super();
//		this.doctorService = doctorService;
//	}
//
//
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//	     User user = doctorService.findDoctorByEmail(email);
//
//		return new CurrentUser(user);
//	}
//	
//
//}
