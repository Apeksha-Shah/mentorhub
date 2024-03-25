package com.apeksha.springboot_first.project1.Services;

import com.apeksha.springboot_first.project1.DaoLayer.MentorDao;
import com.apeksha.springboot_first.project1.DaoLayer.StudentDao;
import com.apeksha.springboot_first.project1.Entity.Mentor;
import com.apeksha.springboot_first.project1.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private MentorDao mentorDao;

    @Override
    @Transactional
    public void save(Student student) {
         studentDao.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentDao.findById(id).get();
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    @Transactional
    public String deleteById(int id) {
        Student student = findById(id);
        if(student == null)
            return "student with id "+id+" is not present";
        studentDao.deleteById(id);
        return "deleted successfully";
    }

    @Override
    @Transactional
    public Student associate(int s_id, int m_id){
        Student student = findById(s_id);
        List<Mentor>mentors = student.getMentors();
        Mentor mentor = mentorDao.findById(m_id).get();
        mentors.add(mentor);
        student.setMentors(mentors);
        save(student);
        return student;
    }

    @Override
    @Transactional
    public Student deleteAssociation(int s_id, int m_id){
        Student student = findById(s_id);
        Mentor mentor = mentorDao.findById(m_id).get();
        List<Mentor>mentors = student.getMentors();
        mentors.remove(mentor);
        student.setMentors(mentors);
        save(student);
        return student;
    }
}
