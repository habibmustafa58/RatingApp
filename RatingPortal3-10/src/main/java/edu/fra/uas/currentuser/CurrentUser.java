package edu.fra.uas.currentuser;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.security.core.authority.AuthorityUtils;

import edu.fra.uas.user.model.Role;
import edu.fra.uas.user.model.User;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
    	super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
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
