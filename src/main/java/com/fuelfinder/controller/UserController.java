package com.fuelfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fuelfinder.dao.UserDao;
import com.fuelfinder.model.User;

@RestController
@RequestMapping(value = "user/")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "hello")
    public String index() {
        return "Hello world";
    }

    @RequestMapping(value = "test")
    public User test() {
        User ret = new User();
        try {
            User u = new User();
            u.setFirstname("Nikson");
            u.setLastname("Paul");
            u.setEmail("nikson_kanti.paul@tu-dresden.de");
            ret = userDao.save(u);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ret;
    }

}