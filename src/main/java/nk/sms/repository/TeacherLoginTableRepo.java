package nk.sms.repository;

import nk.sms.entity.TeacherLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherLoginTableRepo extends JpaRepository<TeacherLoginEntity,String> {
}
