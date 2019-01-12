package com.safu.safecoin.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Sample {


//    @Autowired
//    private UserService userService;

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public Map<String, Object> getUserById(@PathVariable("userId") long userId) {
        return null;
    }
}