package com.apeksha.springboot_first.project1.DaoLayer;

import com.apeksha.springboot_first.project1.Entity.Mentor;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface MentorDao extends Serializable , JpaRepository<Mentor, Integer> {

}
