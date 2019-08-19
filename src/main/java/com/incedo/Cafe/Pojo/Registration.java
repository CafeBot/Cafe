package com.incedo.Cafe.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Registration {

    @JsonProperty("login_details")
    private Login login_details;

    @JsonProperty("user_details")
    private User_details user_details;

    @Override
    public String toString() {
        return "Registration{" +
                "login_details=" + login_details +
                ", user_details=" + user_details +
                '}';
    }

    public Login getLogin_details() {
        return login_details;
    }

    public void setLogin_details(Login login_details) {
        this.login_details = login_details;
    }

    public User_details getUser_details() {
        return user_details;
    }

    public void setUser_details(User_details user_details) {
        this.user_details = user_details;
    }
}
