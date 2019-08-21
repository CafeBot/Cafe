package com.incedo.Cafe.Services;

import com.incedo.Cafe.Pojo.Login;
import com.incedo.Cafe.Pojo.Registration;
import com.incedo.Cafe.Repository.LoginDAO;

public class LoginService {
    LoginDAO loginDAO = new LoginDAO();


    public Registration Authenticate(Login loginCredentials) {
        return loginDAO.Authenticate(loginCredentials);
    }

    public String RegisterUser(Registration register) {
        return loginDAO.RegisterUser(register);
    }
}
