package nk.sms.service;

import nk.sms.repository.StudentLoginTableRepo;
import nk.sms.repository.TeacherLoginTableRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SignupService {
    @Autowired
    private StudentLoginTableRepo studentLoginTableRepo;
    @Autowired
    private TeacherLoginTableRepo teacherLoginTableRepo;

    public boolean doesTeacherExist(String email){
      return  teacherLoginTableRepo.existsByEmail(email);
    }

    public boolean doesStudentExist(String email){
        return  studentLoginTableRepo.existsByEmail(email);
    }
}
