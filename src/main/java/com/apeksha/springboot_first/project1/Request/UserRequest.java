package com.apeksha.springboot_first.project1.Request;

import com.apeksha.springboot_first.project1.Entity.Role;
import com.apeksha.springboot_first.project1.Request.StudentRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private int userId;

    private String registrationNumber;

    private String username;

    private String password;

    private RoleRequest role;

    private StudentRequest student;

    private MentorRequest mentor;

}
