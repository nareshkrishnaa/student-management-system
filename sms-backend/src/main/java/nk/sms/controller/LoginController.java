package nk.sms.controller;

import nk.sms.dto.LoginDto;
import nk.sms.dto.SignupDto;
import nk.sms.entity.StudentEntity;
import nk.sms.entity.TeacherEntity;
import nk.sms.repository.StudentLoginTableRepo;
import nk.sms.repository.TeacherLoginTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/sms")
public class LoginController {
    private final StudentLoginTableRepo studentLoginTableRepo;
    private final TeacherLoginTableRepo teacherLoginRepo;

    @Autowired
    public LoginController(StudentLoginTableRepo studentLoginTableRepo, TeacherLoginTableRepo teacherLoginRepo) {
        this.studentLoginTableRepo = studentLoginTableRepo;
        this.teacherLoginRepo = teacherLoginRepo;
    }

    public Optional<TeacherEntity> findTeacherUser(List<TeacherEntity> list, String email, String password){
        return list.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst();
    }

    public Optional<StudentEntity> findStudentUser(List<StudentEntity>list, String email, String password){
        return list.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst();
    }

    //http://localhost:8082/login
    @PostMapping("/login")
    public ResponseEntity<String> loginApi(@RequestBody LoginDto loginDto) {
        System.out.println(loginDto.toString());
        List<StudentEntity> loginStudentListFromDB = studentLoginTableRepo.findAll();
        List<TeacherEntity> loginTeacherListFromDB = teacherLoginRepo.findAll();

        if (Objects.equals(loginDto.getLoginType(), "Teacher")) {
            System.out.println(Arrays.toString(loginTeacherListFromDB.toArray()));
            Optional<TeacherEntity> foundUser = findTeacherUser(loginTeacherListFromDB, loginDto.getEmail(), loginDto.getPassword());

            if (foundUser.isPresent()) {
                TeacherEntity te = foundUser.get();
                return ResponseEntity.ok(te.getName());
            } else {
                System.out.println("No matching user found.");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }
        } else {
            System.out.println(loginStudentListFromDB);
            Optional<StudentEntity> foundUser = findStudentUser(loginStudentListFromDB, loginDto.getEmail(), loginDto.getPassword());

            if (foundUser.isPresent()) {
                System.out.println("User found: " + foundUser.get());
                StudentEntity se = foundUser.get();
                return ResponseEntity.ok(se.getName());
            } else {
                System.out.println("No matching user found.");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }
        }
    }



}
