package nk.sms.repository;

import nk.sms.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentLoginTableRepo extends JpaRepository<StudentEntity,Integer> {
    boolean existsByEmail(String email); // Checks if a user exists by email

}
