package com.apeksha.springboot_first.project1.Services;

import com.apeksha.springboot_first.project1.DaoLayer.MentorDao;
import com.apeksha.springboot_first.project1.DaoLayer.StudentDao;
import com.apeksha.springboot_first.project1.Entity.Mentor;
import com.apeksha.springboot_first.project1.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class MentorServiceImpl implements MentorService{

    @Autowired
    private MentorDao mentorDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public void save(Mentor mentor) {
        mentorDao.save(mentor);
    }

    @Override
    public Mentor findById(int id) {
        return mentorDao.findById(id).get();
    }

    @Override
    public List<Mentor> findAll() {
        return mentorDao.findAll();
    }

    @Override
    @Transactional
    public String deleteById(int id) {
        Mentor mentor = findById(id);
        if(mentor == null)
            return "student with id "+id+" is not present";
        mentorDao.deleteById(id);
        return "deleted successfully";
    }

    @Override
    @Transactional
    public Mentor deleteAssociation(int m_id,int s_id){
        Mentor mentor = findById(m_id);
        Student student = studentDao.findById(s_id).get();
        List<Student>list = mentor.getStudents();
        list.remove(student);
        mentor.setStudents(list);
        save(mentor);
        return mentor;
    }
}
