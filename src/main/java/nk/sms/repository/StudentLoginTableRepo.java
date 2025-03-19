package nk.sms.repository;

import nk.sms.entity.StudentLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentLoginTableRepo extends JpaRepository<StudentLoginEntity,String> {
}
