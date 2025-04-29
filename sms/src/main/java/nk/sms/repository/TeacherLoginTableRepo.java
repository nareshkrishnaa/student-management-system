package nk.sms.repository;

import nk.sms.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherLoginTableRepo extends JpaRepository<TeacherEntity,Integer> {
    boolean existsByEmail(String email); // Checks if a user exists by email
}
