package com.apeksha.springboot_first.project1.Services;

import com.apeksha.springboot_first.project1.Entity.Mentor;

import java.util.List;

public interface MentorService {
    public void save(Mentor mentor);
    public Mentor findById(int id);
    public List<Mentor> findAll();
    public String deleteById(int id);
    public Mentor deleteAssociation(int m_id,int s_id);
}
