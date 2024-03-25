package com.apeksha.springboot_first.project1.Services;

import com.apeksha.springboot_first.project1.DaoLayer.MentorDao;
import com.apeksha.springboot_first.project1.DaoLayer.StudentDao;
import com.apeksha.springboot_first.project1.DaoLayer.UserDao;
import com.apeksha.springboot_first.project1.Entity.Mentor;
import com.apeksha.springboot_first.project1.Entity.Role;
import com.apeksha.springboot_first.project1.Entity.Student;
import com.apeksha.springboot_first.project1.Entity.User;
import com.apeksha.springboot_first.project1.Request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private MentorDao mentorDao;

    @Override
    public String save(UserRequest userRequest) {

        //------------------- this will handle row insertion in user table--------------------------
        // Builder Pattern

        if(userRequest.getRole().getRoleId()==2 && userRequest.getStudent() == null) {
            return "Please enter student details";
        }

        if(userRequest.getRole().getRoleId()==1 && userRequest.getMentor() == null) {
            return "Please enter mentor details";
        }


        User user1 = userDao.save(User.builder()
                 .password(userRequest.getPassword())
                 .username(userRequest.getUsername())
                 .registrationNumber(userRequest.getRegistrationNumber())
                   .role(Role.builder()
                        .roleId(userRequest.getRole().getRoleId())
                        .roleName(userRequest.getRole().getRoleName())
                        .build())
                .build());

        // ---------------- this will handle row insertion in student table along with user mapping ------------
        if(user1.getRole().getRoleId()==2) {
            Student student1 = studentDao.save(Student.builder()
                    .email(userRequest.getStudent().getEmail())
                    .dateOfBirth(userRequest.getStudent().getDateOfBirth())
                    .lastName(userRequest.getStudent().getLastName())
                    .firstName(userRequest.getStudent().getFirstName())
                    .mobileNo(userRequest.getStudent().getMobileNo())
                    .registrationNumber(userRequest.getStudent().getRegistrationNumber())
                    .user(user1)
                    .build());
        }
        if(user1.getRole().getRoleId()==1){
            Mentor mentor1 = mentorDao.save(Mentor.builder()
                    .dateOfBirth(userRequest.getMentor().getDateOfBirth())
                    .email(userRequest.getMentor().getEmail())
                    .firstName(userRequest.getMentor().getFirstName())
                    .lastName(userRequest.getMentor().getLastName())
                    .mobileNo(userRequest.getMentor().getMobileNo())
                    .registrationNumber(userRequest.getMentor().getRegistrationNumber())
                    .user(user1)
                    .build());
        }
        // --------------- add foreign key in student -------------------
        return "Data Saved Successfully";
    }

    @Override
    public User findById(int userId) {
        Optional<User>user = userDao.findById(userId);
        return user.isPresent() ? user.get() : null;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public String deleteById(int userId) {
        Optional<User>user = userDao.findById(userId);
        User user1 = null;
        if(user.isPresent()) {
            user1 = user.get();
            userDao.delete(user1);
            return "Deleted Successfully";
        }
        return "User with userid "+userId+" is not present";
    }

    public String update(UserRequest userRequest,int user_id){

        if(userRequest.getRole().getRoleId()==2 && userRequest.getStudent() == null) {
            return "Please enter student details";
        }

        if(userRequest.getRole().getRoleId()==1 && userRequest.getMentor() == null) {
            return "Please enter mentor details";
        }

        User user1 = userDao.save(User.builder()
                     .userId(user_id)
                     .password(userRequest.getPassword())
                     .registrationNumber(userRequest.getRegistrationNumber())
                     .username(userRequest.getUsername())
                     .role(Role.builder()
                                  .roleId(userRequest.getRole().getRoleId())
                                  .roleName(userRequest.getRole().getRoleName())
                                  .build())
                    .build());


        if(userRequest.getStudent()!=null) {
            if (userRequest.getRole().getRoleId() == 2 && userRequest.getStudent().getId() != 0) {
                studentDao.save(Student.builder()
                        .id(userRequest.getStudent().getId())
                        .email(userRequest.getStudent().getEmail())
                        .dateOfBirth(userRequest.getStudent().getDateOfBirth())
                        .lastName(userRequest.getStudent().getLastName())
                        .firstName(userRequest.getStudent().getFirstName())
                        .mobileNo(userRequest.getStudent().getMobileNo())
                        .registrationNumber(userRequest.getStudent().getRegistrationNumber())
                        .user(user1)
                        .build());
            }
            else if(userRequest.getRole().getRoleId()==2 && userRequest.getStudent().getId()==0)
                return "Please enter student id";
        }
        if(userRequest.getMentor()!=null) {
            if (userRequest.getRole().getRoleId() == 1 && userRequest.getMentor().getId() != 0) {
                mentorDao.save(Mentor.builder()
                        .id(userRequest.getMentor().getId())
                        .dateOfBirth(userRequest.getMentor().getDateOfBirth())
                        .email(userRequest.getMentor().getEmail())
                        .firstName(userRequest.getMentor().getFirstName())
                        .lastName(userRequest.getMentor().getLastName())
                        .mobileNo(userRequest.getMentor().getMobileNo())
                        .registrationNumber(userRequest.getMentor().getRegistrationNumber())
                        .user(user1)
                        .build());
            }
            else if(userRequest.getRole().getRoleId()==1 && userRequest.getMentor().getId()==0)
                 return "Please enter mentor id";
        }
        return "Data Updated Successfully";
    }

    @Override
    @Transactional
    public User saveStudent(Student student,int uid){
        Optional<User> optional = userDao.findById(uid);
        User user = null;
        if(optional.isPresent()) {
            user = optional.get();
            userDao.save(user);
        }
        return user;
    }
}
