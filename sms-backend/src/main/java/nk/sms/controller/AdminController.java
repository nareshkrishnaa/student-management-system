package nk.sms.controller;


import nk.sms.entity.StudentEntity;
import nk.sms.entity.TeacherEntity;
import nk.sms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("sms/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/get-student-list")
    public ResponseEntity<List<StudentEntity>> getListOfStudents(){
        List<StudentEntity> allStudents =  adminService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(allStudents);
    }

    @GetMapping("/get-teacher-list")
    public ResponseEntity<List<TeacherEntity>> getListOfTeachers(){
        List<TeacherEntity> allTeachers = adminService.getAllTeachers();
        return ResponseEntity.status(HttpStatus.OK).body(allTeachers);
    }

}
