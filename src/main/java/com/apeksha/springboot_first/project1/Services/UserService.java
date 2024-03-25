package com.apeksha.springboot_first.project1.Services;

import com.apeksha.springboot_first.project1.Entity.Student;
import com.apeksha.springboot_first.project1.Entity.User;
import com.apeksha.springboot_first.project1.Request.UserRequest;

import java.util.List;

public interface UserService {
    public String save(UserRequest userRequest);
    public User findById(int userId);
    public List<User> findAll();
    public String deleteById(int userId);
    public User saveStudent(Student student,int uid);
    public String update(UserRequest user,int user_id);
}
