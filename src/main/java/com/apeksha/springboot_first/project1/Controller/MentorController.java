package com.apeksha.springboot_first.project1.Controller;

import com.apeksha.springboot_first.project1.Entity.Mentor;
import com.apeksha.springboot_first.project1.Entity.Student;
import com.apeksha.springboot_first.project1.Services.MentorService;
import com.apeksha.springboot_first.project1.Services.MentorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MentorController {
    private MentorService mentorService;
    @Autowired
    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @PostMapping("/mentors")
    public Mentor save(@RequestBody Mentor mentor){
        mentorService.save(mentor);
        return mentor;
    }

    @GetMapping("/mentors")
    public List<Mentor> findAll(){
        return mentorService.findAll();
    }

    @GetMapping("/mentors/{m_id}")
    public Mentor findById(@PathVariable int m_id){
        return mentorService.findById(m_id);
    }

    @PutMapping("/mentors")
    public Mentor update(@RequestBody Mentor m){
        mentorService.save(m);
        return m;
    }

    @DeleteMapping("/mentors/{id}")
    public String remove(@PathVariable int id){
        return mentorService.deleteById(id);
    }
    @DeleteMapping("/deleteAssociation/mentor/{m_id}/student/{s_id}")
    public Mentor deletion(@PathVariable int m_id,@PathVariable int s_id){
        return mentorService.deleteAssociation(m_id,s_id);
    }
}
