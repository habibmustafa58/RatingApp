package edu.fra.uas.currentuser;

import edu.fra.uas.user.model.Role;
import edu.fra.uas.user.model.User;

public class CurrentUser extends User {

    private User user;

    public CurrentUser(User user) {
    	super(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getRole());
    	this.user = user;
    }
    
    public User getUser() {
        return user;
    }

    public long getId() {
        return user.getId();
    }

    public String getName() {
        return user.getName();
    }
    
    public Role getRole() {
    	return user.getRole();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }

}
