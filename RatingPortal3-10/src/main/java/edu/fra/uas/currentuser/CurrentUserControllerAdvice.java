//package edu.fra.uas.currentuser;
//
//
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//
//@ControllerAdvice
//public class CurrentUserControllerAdvice {
//	
//
//    @ModelAttribute("currentUser")
//    public CurrentUser getCurrentUser(Authentication authentication) {
//        return (authentication == null) ? null : (CurrentUser) authentication.getPrincipal();
//    }
//
//}
