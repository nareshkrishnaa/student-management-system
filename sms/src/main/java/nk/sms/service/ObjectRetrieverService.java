package nk.sms.service;

import nk.sms.entity.StudentEntity;
import nk.sms.entity.TeacherEntity;
import nk.sms.repository.StudentLoginTableRepo;
import nk.sms.repository.TeacherLoginTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ObjectRetrieverService {
    @Autowired
    private StudentLoginTableRepo studentLoginTableRepo;
    @Autowired
    private TeacherLoginTableRepo teacherLoginTableRepo;


    public StudentEntity getStudentEntity(Integer id){
        return studentLoginTableRepo.findById(id).orElse(null);
    }

    public TeacherEntity getTeacherEntity(Integer id){
        return teacherLoginTableRepo.findById(id).orElse(null);
    }


}
