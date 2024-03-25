package com.apeksha.springboot_first.project1.Request;

import com.apeksha.springboot_first.project1.Entity.Mentor;
import com.apeksha.springboot_first.project1.Entity.User;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class StudentRequest {

    private int id;

    private String registrationNumber;

    private String firstName;

    private String lastName;

    private long mobileNo;

    private Date dateOfBirth;

    private String email;

    private List<MentorRequest> mentors;

    private UserRequest user;
}
