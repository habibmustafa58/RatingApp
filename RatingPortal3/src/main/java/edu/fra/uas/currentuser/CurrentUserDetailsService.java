//package edu.fra.uas.currentuser;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import edu.fra.uas.user.model.User;
//import edu.fra.uas.user.service.UserService;
//
//
//@Service
//	public class CurrentUserDetailsService  {
//	    
//	    private UserService userService;
//
//	    @Autowired
//	    public CurrentUserDetailsService(UserService userService) {
//	        this.userService = userService;
//	    }
//
//	    public CurrentUser loadUserByUsername(String email){
//	        User user = userService.getDoctorByEmail(email);
//	        return new CurrentUser(user);
//	    }
//}
