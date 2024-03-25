package com.apeksha.springboot_first.project1.DaoLayer;

import com.apeksha.springboot_first.project1.Entity.Student;
import com.apeksha.springboot_first.project1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

}
