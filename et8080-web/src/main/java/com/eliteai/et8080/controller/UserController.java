package com.eliteai.et8080.controller;

import com.eliteai.et8080.model.User;
import com.eliteai.et8080.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MR.ZHANG
 * @create 2018-08-20 10:03
 */
@RestController
@RequestMapping("/api/v1.1")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/index")
    public User showIndex() {
        User user = userService.selectUserById(1);
        return user;
    }
    @GetMapping("/hello")
    @ResponseBody
    public String sss() {
        return "fss";
    }
}
