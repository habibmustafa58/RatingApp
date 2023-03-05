package edu.fra.uas.currentuser;

import org.springframework.stereotype.Component;

@Component
public class CurrentUser {
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
