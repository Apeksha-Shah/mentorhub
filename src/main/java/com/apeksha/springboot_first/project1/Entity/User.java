package com.apeksha.springboot_first.project1.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "user_id")
     private int userId;

     @Column(name = "registration_number")
     private String registrationNumber;

     @Column(name = "username")
     private String username;

     @Column(name = "password",length = 8)
     private String password;

     @ManyToOne
     @JoinColumn(name = "user_role_id")
     private Role role;

     @JsonIgnoreProperties("user")
     @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
     private Student student;

     @JsonIgnoreProperties("user")
     @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
     private Mentor mentor;
}

