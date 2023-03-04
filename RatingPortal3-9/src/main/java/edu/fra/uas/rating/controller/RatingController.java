package edu.fra.uas.rating.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.fra.uas.user.service.UserService;
@Controller
public class RatingController {

    private UserService doctorService;

//@Autowired
//    public RatingController(UserService doctorService) {
//        this.setDoctorService(new UserService());
//		this.UserService = doctorService;
//    }
@Autowired
	public RatingController() {
		
	}

//    @RequestMapping("/homepage")
//    public String home(Model model) {
//        List<Doctor> doctors = UserService.getAllDoctors();
//        model.addAttribute("doctors", doctors);
//        
//        return "homepage";
//    }


    @RequestMapping("/homepage")
    public String gethomepage(Model model) {
   
        return "homepage";
    }

    @RequestMapping("/login1")
    public String getlogin(Model model) {
        return "login";
    }

    @RequestMapping("/logout")
    public String getlogout(Model model) {
        return "logout";
    }
    
    @RequestMapping("/docstart")
    public String getarztstart () {
    	return "arztstart";
    }
    
    
//    @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
//	public String getlogin(@RequestParam Optional<String> error, Model model) {
//		
//		return "login";
//    }
    
    

	public UserService getDoctorService() {
		return doctorService;
	}

	public void setDoctorService(UserService doctorService) {
		this.doctorService = doctorService;
	}


}

