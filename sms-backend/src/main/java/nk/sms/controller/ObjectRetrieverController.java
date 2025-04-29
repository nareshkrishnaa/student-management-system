package nk.sms.controller;


import nk.sms.entity.StudentEntity;
import nk.sms.entity.TeacherEntity;
import nk.sms.service.ObjectRetrieverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("sms")
public class ObjectRetrieverController {
    @Autowired
    private ObjectRetrieverService objectRetrieverService ;
    @GetMapping("/get-student/{id}")
    public ResponseEntity<StudentEntity> getStudent(@PathVariable Integer id){
        System.out.println(id);
        return null;
    }

    @GetMapping("/get-teacher/{id}")
    public ResponseEntity<TeacherEntity> getTeacher(@PathVariable Integer id){
        System.out.println(id);
        return null;
    }
}
