package com.apeksha.springboot_first.project1.Services;

import com.apeksha.springboot_first.project1.Entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentService {
    public void save(Student student);
    public Student findById(int id);
    public List<Student> findAll();
    public String deleteById(int id);
    public Student associate(int s_id,int m_id);
    public Student deleteAssociation(int s_id,int m_id);

}
