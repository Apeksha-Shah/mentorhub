package com.apeksha.springboot_first.project1.Request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
public class MentorRequest {

    private int id;

    private String registrationNumber;

    private String firstName;

    private String lastName;

    private long mobileNo;

    private Date dateOfBirth;

    private String email;

    private List<StudentRequest> students;

    private UserRequest user;

}
