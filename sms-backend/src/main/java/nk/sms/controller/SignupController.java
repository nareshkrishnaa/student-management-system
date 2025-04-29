package nk.sms.controller;

import nk.sms.dto.SignupDto;
import nk.sms.entity.StudentEntity;
import nk.sms.entity.TeacherEntity;
import nk.sms.repository.StudentLoginTableRepo;
import nk.sms.repository.TeacherLoginTableRepo;
import nk.sms.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/sms")
public class SignupController {
    @Autowired
    private StudentLoginTableRepo studentLoginTableRepo;
    @Autowired
    private TeacherLoginTableRepo teacherLoginTableRepo;
    @Autowired
    private SignupService signupService;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignupDto signupDto){
        System.out.println("Check point 1 : "+signupDto.toString());
        if(signupDto.getSignupType().equals("Teacher")){
            if(signupService.doesTeacherExist(signupDto.getEmail())){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
            }

            TeacherEntity user = new TeacherEntity();
            user.setName(signupDto.getName());
            user.setEmail(signupDto.getEmail());
            user.setPassword(signupDto.getPassword()); // Consider hashing the password
            teacherLoginTableRepo.save(user);
            System.out.println("Saved");
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully!");
        }else{
            if(signupService.doesStudentExist(signupDto.getEmail())){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
            }

            StudentEntity user = new StudentEntity();
            user.setName(signupDto.getName());
            user.setEmail(signupDto.getEmail());
            user.setPassword(signupDto.getPassword()); // Consider hashing the password
            studentLoginTableRepo.save(user);
            System.out.println("Saved");

            return ResponseEntity.status(HttpStatus.CREATED).body(user.getName());
        }

    }

}
