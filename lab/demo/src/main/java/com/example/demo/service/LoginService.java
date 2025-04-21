package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Login;
import com.example.demo.repository.LoginRepo;

@Service
public class LoginService {

    @Autowired
    private LoginRepo repo;
    public Login log(String username, String password) {
        Login user = repo.findByUsernameAndPassword(username, password);
    

    if(user!= null)
    {
        return user;
    }
   Login nuser = new Login();
    nuser.setUsername(username);
    repo.save(nuser);
    return null;
    }

}
