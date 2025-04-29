package nk.sms.service;

import nk.sms.entity.StudentEntity;
import nk.sms.entity.TeacherEntity;
import nk.sms.repository.StudentLoginTableRepo;
import nk.sms.repository.TeacherLoginTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class AdminService {
    private StudentLoginTableRepo studentLoginTableRepo;
    private TeacherLoginTableRepo teacherLoginTableRepo;

    @Autowired
    public AdminService(StudentLoginTableRepo studentLoginTableRepo, TeacherLoginTableRepo teacherLoginTableRepo) {
        this.studentLoginTableRepo = studentLoginTableRepo;
        this.teacherLoginTableRepo = teacherLoginTableRepo;
    }

    public List<StudentEntity> getAllStudents(){
       List<StudentEntity> allStudents = studentLoginTableRepo.findAll();
        System.out.println(Arrays.toString(allStudents.toArray()));
        return allStudents;
    }

    public List<TeacherEntity> getAllTeachers(){
        List<TeacherEntity> allTeachers = teacherLoginTableRepo.findAll();
        System.out.println(Arrays.toString(allTeachers.toArray()));
        return allTeachers;
    }

//    public void getStudentsNameAndIdList(){
//        List<StudentEntity> allStudents = studentLoginTableRepo.findAll();
//        for(StudentEntity se : allStudents){
//
//        }
//    }
}
