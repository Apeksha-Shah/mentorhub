package com.apeksha.springboot_first.project1.Request;

import com.apeksha.springboot_first.project1.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
public class RoleRequest {

    private int roleId;

    private String roleName;

}
