package com.apeksha.springboot_first.project1.Controller;

import com.apeksha.springboot_first.project1.Entity.Student;
import com.apeksha.springboot_first.project1.Services.UserService;
import com.apeksha.springboot_first.project1.Request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.apeksha.springboot_first.project1.Entity.User;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    {
//        "userId":5,
//            "role":{
//        "roleId":2,
//                "roleName":"Mentor"
//    },
//        "password":"abc@1234",
//            "registrationNumber":"23CEUON123",
//            "username":"Arshi shah"
//    }

    @PostMapping("/users")
    public String save(@RequestBody UserRequest user){
        return userService.save(user);
    }

    @GetMapping("/users")
    public List<User> findUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{user_id}")
    public User findById(@PathVariable int user_id){
        return userService.findById(user_id);
    }

    @PutMapping("/users")
    public UserRequest update(@RequestBody UserRequest user){
         userService.save(user);
         return user;
    }

    @DeleteMapping("/users/{user_id}")
    public String deleteById(@PathVariable int user_id){
        return userService.deleteById(user_id);
    }

    @PutMapping("/users/students/{uid}")
    public User update(@RequestBody Student student,@PathVariable int uid) {
        return userService.saveStudent(student, uid);
    }

}
