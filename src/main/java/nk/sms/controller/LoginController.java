package nk.sms.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nk.sms.dto.LoginDto;
import nk.sms.entity.StudentLoginEntity;
import nk.sms.entity.TeacherLoginEntity;
import nk.sms.repository.StudentLoginTableRepo;
import nk.sms.repository.TeacherLoginTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {
    private final StudentLoginTableRepo studentLoginTableRepo;
    private final TeacherLoginTableRepo teacherLoginRepo;

    @Autowired
    public LoginController(StudentLoginTableRepo studentLoginTableRepo, TeacherLoginTableRepo teacherLoginRepo) {
        this.studentLoginTableRepo = studentLoginTableRepo;
        this.teacherLoginRepo = teacherLoginRepo;
    }

    public Optional<TeacherLoginEntity> findTeacherUser(List<TeacherLoginEntity> list,String email,String password){
        return list.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst();
    }

    public Optional<StudentLoginEntity> findStudentUser(List<StudentLoginEntity>list,String email,String password){
        return list.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst();
    }
    //http://localhost:8082/login
    @PostMapping
    public void loginApi(@RequestBody LoginDto loginDto){
        System.out.println(loginDto.toString());
        List<StudentLoginEntity> loginStudentListFromDB = studentLoginTableRepo.findAll();
        List<TeacherLoginEntity> loginTeacherListFromDB =teacherLoginRepo.findAll();

        if(Objects.equals(loginDto.getLoginType(),"Teacher")){
            System.out.println(Arrays.toString(loginTeacherListFromDB.toArray()));
            Optional<TeacherLoginEntity> foundUser = findTeacherUser(loginTeacherListFromDB,loginDto.getEmail(),loginDto.getPassword());
            foundUser.ifPresentOrElse(
                    user -> System.out.println("User found: " + user),
                    () -> System.out.println("No matching user found.")
            );

        }else {
            System.out.println(loginStudentListFromDB);
            Optional<StudentLoginEntity> foundUser = findStudentUser(loginStudentListFromDB,loginDto.getEmail(),loginDto.getPassword());
            foundUser.ifPresentOrElse(
                    user -> System.out.println("User found: " + user),
                    () -> System.out.println("No matching user found.")
            );
        }
    }

}
