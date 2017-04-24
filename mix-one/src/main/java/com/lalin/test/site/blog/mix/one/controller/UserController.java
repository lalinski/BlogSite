package com.lalin.test.site.blog.mix.one.controller;

import com.lalin.test.site.blog.mix.one.Dao.User;
import com.lalin.test.site.blog.mix.one.Dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by frzhao on 2017/4/22.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/register")
    public String userSave(@RequestParam("username") String name, @RequestParam("password") String password){
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        SimpleGrantedAuthority grant = new SimpleGrantedAuthority("ROLE_USER");
        Set<SimpleGrantedAuthority> set = new HashSet<>();
        set.add(grant);
        user.setAuthorities(set);
        userRepository.save(user);
     //   return "forward:/index";
        return "username: " + name +"<br/>" + "password: " + password;
    }

    @RequestMapping("/find/{id}")
    public String find(@PathVariable("id") Integer ids){
         User user = userRepository.findOne(ids);
         System.out.println(user.toString());
         return user.toString();
    }
    @RequestMapping("/findname/{name}")
    public String find(@PathVariable("name") String name){
        List<User> list = new ArrayList<User>();
        list = userRepository.findByUsername(name);
        if(list != null && list.size() > 0)
        System.out.println(list.get(0).toString());
        return list.get(0).toString();
    }
}
