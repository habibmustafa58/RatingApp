//package edu.fra.uas.currentuser;
//
//import org.springframework.ui.Model;
//
//public class CurrentUser1 {
//	public static String getCurrentUser(Model model) {
//		CurrentUser currentUser =(CurrentUser) model.asMap().get("currentUser");
//		String from = currentUser.getName();
//		model.addAttribute("fromUser", from);
//		return from;
//	}
//}
